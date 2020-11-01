package pl.cwanix.opensun.authserver.packet.processors.auth;

import io.netty.channel.ChannelHandlerContext;
import lombok.RequiredArgsConstructor;
import pl.cwanix.opensun.authserver.communication.DatabaseProxyConnector;
import pl.cwanix.opensun.authserver.packet.c2s.auth.C2SAskAuthPacket;
import pl.cwanix.opensun.authserver.packet.s2c.auth.S2CAnsAuthPacket;
import pl.cwanix.opensun.authserver.server.AuthServerChannelHandler;
import pl.cwanix.opensun.authserver.server.session.AuthServerSession;
import pl.cwanix.opensun.commonserver.packets.SUNPacketProcessor;
import pl.cwanix.opensun.commonserver.packets.annotations.PacketProcessor;
import pl.cwanix.opensun.domain.UserDTO;
import pl.cwanix.opensun.utils.encryption.TEA;

@SuppressWarnings("checkstyle:MagicNumber")
@RequiredArgsConstructor
@PacketProcessor(packetClass = C2SAskAuthPacket.class)
public class C2SAskAuthProcessor implements SUNPacketProcessor<C2SAskAuthPacket> {

    private final DatabaseProxyConnector databaseProxyConnector;

    @Override
    public void process(final ChannelHandlerContext ctx, final C2SAskAuthPacket packet) {
        AuthServerSession session = ctx.channel().attr(AuthServerChannelHandler.SESSION_ATTRIBUTE).get();

        String decodedPass = new String(TEA.passwordDecode(packet.getPassword().toByteArray(), session.getEncKey()));
        UserDTO userDTO = databaseProxyConnector.findUser(packet.getName().toString());
        S2CAnsAuthPacket ansAuthPacket;

        if (userDTO == null) {
            ansAuthPacket = new S2CAnsAuthPacket(1);
        } else if (!decodedPass.equals(userDTO.getPassword())) {
            ansAuthPacket = new S2CAnsAuthPacket(2);
        } else if (databaseProxyConnector.startAgentServerSession(userDTO.getId()) > 0) {
            ansAuthPacket = new S2CAnsAuthPacket(3);
        } else {
            session.setUser(userDTO);
            ansAuthPacket = new S2CAnsAuthPacket(0);
        }

        ctx.writeAndFlush(ansAuthPacket);
    }
}
