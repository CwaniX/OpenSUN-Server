package pl.cwanix.opensun.agentserver.packets.processors.connection;

import io.netty.channel.ChannelHandlerContext;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.jboss.logging.MDC;
import org.slf4j.Marker;
import org.slf4j.MarkerFactory;
import pl.cwanix.opensun.agentserver.communication.DatabaseProxyConnector;
import pl.cwanix.opensun.agentserver.entities.CharacterEntity;
import pl.cwanix.opensun.agentserver.entities.UserEntity;
import pl.cwanix.opensun.agentserver.packets.c2s.connection.C2SAskEnterServerPacket;
import pl.cwanix.opensun.agentserver.packets.s2c.connection.S2CAnsEnterServerPacket;
import pl.cwanix.opensun.agentserver.server.AgentServerChannelHandler;
import pl.cwanix.opensun.agentserver.server.session.AgentServerSession;
import pl.cwanix.opensun.agentserver.server.session.AgentServerSessionManager;
import pl.cwanix.opensun.commonserver.packets.SUNPacketProcessor;
import pl.cwanix.opensun.commonserver.packets.annotations.PacketProcessor;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@PacketProcessor(packetClass = C2SAskEnterServerPacket.class)
public class C2SAskEnterServerProcessor implements SUNPacketProcessor<C2SAskEnterServerPacket> {

	private static final Marker MARKER = MarkerFactory.getMarker("C2S -> ASK ENTER SERVER");

	private final AgentServerSessionManager sessionManager;
	private final DatabaseProxyConnector databaseProxyConnector;

	@Override
	public void process(ChannelHandlerContext ctx, C2SAskEnterServerPacket packet) {
		UserEntity user = new UserEntity();
		user.setId(packet.getUserId().toInt());
		user.setName(packet.getUserName().toString());

		log.info(MARKER, "Trying to authorize user with id: {}", user.getId());

		AgentServerSession session = sessionManager.getSession(user);

		if (session == null) {
			log.error(MARKER, "Unable to resolve session data for user: {} with id: {}", user.getName(), user.getId());

			ctx.close();
		} else {
			MDC.put("userId", user.getId());
			log.info(MARKER, "Authorized user with id: {}", user.getId());

			ctx.channel().attr(AgentServerChannelHandler.SESSION_ATTRIBUTE).set(session);

			List<CharacterEntity> characterEntityList = databaseProxyConnector.findCharactersList(session.getUser().getAccount().getId());
			int userId = session.getUser().getId();

			ctx.writeAndFlush(new S2CAnsEnterServerPacket(userId, characterEntityList));
		}
	}
}
