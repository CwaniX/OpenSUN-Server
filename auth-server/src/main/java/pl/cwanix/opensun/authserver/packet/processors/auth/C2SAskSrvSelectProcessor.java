package pl.cwanix.opensun.authserver.packet.processors.auth;

import io.netty.channel.ChannelHandlerContext;
import lombok.RequiredArgsConstructor;
import pl.cwanix.opensun.authserver.communication.DatabaseProxyConnector;
import pl.cwanix.opensun.authserver.packet.c2s.auth.C2SAskSrvSelectPacket;
import pl.cwanix.opensun.authserver.packet.s2c.auth.S2CAnsSrvSelectPacket;
import pl.cwanix.opensun.authserver.server.AuthServerChannelHandler;
import pl.cwanix.opensun.authserver.server.session.AuthServerSession;
import pl.cwanix.opensun.commonserver.packets.SUNPacketProcessor;
import pl.cwanix.opensun.commonserver.packets.annotations.PacketProcessor;
import pl.cwanix.opensun.domain.ServerDTO;

@RequiredArgsConstructor
@PacketProcessor(packetClass = C2SAskSrvSelectPacket.class)
public class C2SAskSrvSelectProcessor implements SUNPacketProcessor<C2SAskSrvSelectPacket> {

    private final DatabaseProxyConnector databaseProxyConnector;

    @Override
    public void process(final ChannelHandlerContext ctx, final C2SAskSrvSelectPacket packet) {
        AuthServerSession session = ctx.channel().attr(AuthServerChannelHandler.SESSION_ATTRIBUTE).get();
        ServerDTO serverDTO = databaseProxyConnector.findServer(packet.getServerIndex().toByte());

        ctx.writeAndFlush(new S2CAnsSrvSelectPacket(session.getUser().getId(), serverDTO.getIp(), serverDTO.getPort()));
    }
}
