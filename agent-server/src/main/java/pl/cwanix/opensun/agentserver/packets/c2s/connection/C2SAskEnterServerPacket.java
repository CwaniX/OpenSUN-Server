package pl.cwanix.opensun.agentserver.packets.c2s.connection;

import java.util.Arrays;

import org.jboss.logging.MDC;
import org.slf4j.Marker;
import org.slf4j.MarkerFactory;

import io.netty.channel.ChannelHandlerContext;
import lombok.extern.slf4j.Slf4j;
import pl.cwanix.opensun.agentserver.entities.UserEntity;
import pl.cwanix.opensun.agentserver.packets.s2c.connection.S2CAnsEnterServerPacket;
import pl.cwanix.opensun.agentserver.server.AgentServerChannelHandler;
import pl.cwanix.opensun.agentserver.server.context.AgentServerContext;
import pl.cwanix.opensun.agentserver.server.session.AgentServerSession;
import pl.cwanix.opensun.commonserver.packets.annotations.IncomingPacket;
import pl.cwanix.opensun.commonserver.packets.Packet;
import pl.cwanix.opensun.commonserver.packets.PacketCategory;
import pl.cwanix.opensun.utils.datatypes.FixedLengthField;

@Slf4j
@IncomingPacket(category = PacketCategory.CONNECTION, type = 0x76)
public class C2SAskEnterServerPacket implements Packet<AgentServerContext> {
	
	private static final Marker MARKER = MarkerFactory.getMarker("C2S -> ASK AUTH");
	
	private FixedLengthField userId;
	private FixedLengthField userName;
	
	public C2SAskEnterServerPacket(byte[] value) {
		this.userId = new FixedLengthField(4, Arrays.copyOfRange(value, 2, 6));
		this.userName = new FixedLengthField(50, Arrays.copyOfRange(value, 7, 54));
	}
	
	@Override
	public void process(ChannelHandlerContext ctx, AgentServerContext srv ) {		
		UserEntity user = new UserEntity();
		user.setId(userId.toInt());
		user.setName(userName.toString());
		
		log.info(MARKER, "Trying to authorize user with id: {}", user.getId());
		
		AgentServerSession session = srv.getSessionManager().getSession(user);
		
		if (session == null) {
			log.error(MARKER, "Unable to resolve session data for user: {} with id: {}", user.getName(), user.getId());
			
			ctx.close();
		} else {
			MDC.put("userId", user.getId());
			log.info(MARKER, "Authorized user with id: {}", user.getId());
			
			ctx.channel().attr(AgentServerChannelHandler.SESSION_ATTRIBUTE).set(session);
			
			ctx.writeAndFlush(new S2CAnsEnterServerPacket());
		}
	}
}
