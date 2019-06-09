package pl.cwanix.opensun.agentserver.packets.c2s;

import java.util.Arrays;

import io.netty.channel.ChannelHandlerContext;
import lombok.extern.slf4j.Slf4j;
import pl.cwanix.opensun.agentserver.entities.UserEntity;
import pl.cwanix.opensun.agentserver.packets.s2c.S2CAnsCharListPacket;
import pl.cwanix.opensun.agentserver.server.AgentServerChannelHandler;
import pl.cwanix.opensun.agentserver.server.session.AgentServerSession;
import pl.cwanix.opensun.agentserver.server.session.AgentServerSessionManager;
import pl.cwanix.opensun.commonserver.packets.ClientPacket;
import pl.cwanix.opensun.utils.bytes.BytesUtils;
import pl.cwanix.opensun.utils.packets.FixedLengthField;
import pl.cwanix.opensun.utils.packets.PacketHeader;

@Slf4j
public class C2SAskAuthPacket extends ClientPacket {

	public static final PacketHeader PACKET_ID = new PacketHeader((byte) 0x48, (byte) 0x76);
	
	private FixedLengthField userId;
	private FixedLengthField userName;
	
	public C2SAskAuthPacket(byte[] value) {
		this.userId = new FixedLengthField(4, Arrays.copyOfRange(value, 2, 6));
		this.userName = new FixedLengthField(50, Arrays.copyOfRange(value, 7, 54));
	}
	
	@Override
	public void process(ChannelHandlerContext ctx) {
		UserEntity user = new UserEntity();
		user.setId(new Long(BytesUtils.byteArrayToShort(userId.getValue())));
		user.setName(userName.toString());
		
		AgentServerSessionManager sessionManager = ctx.channel().attr(AgentServerChannelHandler.SESSION_MANAGER_ATTRIBUTE).getAndSet(null);
		AgentServerSession session = sessionManager.getSession(user);
		
		if (session == null) {
			log.debug("Unable to resolve session data for user: {} with id: {}", user.getName(), user.getId());
		}
		
		ctx.channel().attr(AgentServerChannelHandler.SESSION_ATTRIBUTE).set(session);
		
		S2CAnsCharListPacket ansCharactersListPacket = new S2CAnsCharListPacket();
		ansCharactersListPacket.process(ctx);
		
		ctx.writeAndFlush(ansCharactersListPacket);
	}
}
