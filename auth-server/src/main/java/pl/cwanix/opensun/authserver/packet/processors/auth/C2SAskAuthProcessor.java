package pl.cwanix.opensun.authserver.packet.processors.auth;

import io.netty.channel.ChannelHandlerContext;
import lombok.RequiredArgsConstructor;
import pl.cwanix.opensun.authserver.communication.DatabaseProxyConnector;
import pl.cwanix.opensun.authserver.entities.UserEntity;
import pl.cwanix.opensun.authserver.packet.c2s.auth.C2SAskAuthPacket;
import pl.cwanix.opensun.authserver.packet.s2c.auth.S2CAnsAuthPacket;
import pl.cwanix.opensun.authserver.server.AuthServerChannelHandler;
import pl.cwanix.opensun.authserver.server.session.AuthServerSession;
import pl.cwanix.opensun.commonserver.packets.SUNPacketProcessor;
import pl.cwanix.opensun.commonserver.packets.annotations.PacketProcessor;
import pl.cwanix.opensun.utils.encryption.TEA;

@RequiredArgsConstructor
@PacketProcessor(packetClass = C2SAskAuthPacket.class)
public class C2SAskAuthProcessor implements SUNPacketProcessor<C2SAskAuthPacket> {

	private final DatabaseProxyConnector databaseProxyConnector;

	@Override
	public void process(ChannelHandlerContext ctx, C2SAskAuthPacket packet) {
		AuthServerSession session = ctx.channel().attr(AuthServerChannelHandler.SESSION_ATTRIBUTE).get();

		//String decodedPass = new String(TEA.passwordDecode(packet.getPassword().toByteArray(), session.getEncKey()));
		UserEntity userEntity = databaseProxyConnector.findUser(packet.getName().toString());
		S2CAnsAuthPacket ansAuthPacket;

		/*if (userEntity == null) {
			ansAuthPacket = new S2CAnsAuthPacket(1);
		} else if (!decodedPass.equals(userEntity.getPassword())) {
			ansAuthPacket = new S2CAnsAuthPacket(2);
		} else if (databaseProxyConnector.startAgentServerSession(userEntity.getId()) > 0) {
			ansAuthPacket = new S2CAnsAuthPacket(3);
		} else {*/
			session.setUser(userEntity);
			ansAuthPacket = new S2CAnsAuthPacket(0);
		//}

		ctx.writeAndFlush(ansAuthPacket);
	}
}
