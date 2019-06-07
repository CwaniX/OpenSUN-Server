package pl.cwanix.opensun.agentserver.packets.c2s;

import java.util.Arrays;

import io.netty.channel.ChannelHandlerContext;
import pl.cwanix.opensun.agentserver.entities.UserEntity;
import pl.cwanix.opensun.agentserver.packets.s2c.S2CAnsCharactersListPacket;
import pl.cwanix.opensun.agentserver.server.AgentServerChannelHandler;
import pl.cwanix.opensun.agentserver.server.session.AgentServerSession;
import pl.cwanix.opensun.agentserver.server.session.AgentServerSessionManager;
import pl.cwanix.opensun.commonserver.packets.ClientPacket;
import pl.cwanix.opensun.utils.bytes.BytesUtils;
import pl.cwanix.opensun.utils.packets.FixedLengthField;
import pl.cwanix.opensun.utils.packets.PacketHeader;

public class C2SAskAuthPacket extends ClientPacket {

	public static final PacketHeader PACKET_ID = new PacketHeader((byte) 0x48, (byte) 0x76);
	
	private FixedLengthField userId;
	private FixedLengthField userName;
	
	public C2SAskAuthPacket(byte[] value) {
		this.userId = new FixedLengthField(2, value[1], value[2]);
		this.userName = new FixedLengthField(50, Arrays.copyOfRange(value, 3, 54));
	}
	
	@Override
	public void process(ChannelHandlerContext ctx) {
		UserEntity user = new UserEntity();
		user.setId((long) BytesUtils.byteArrayToShort(userId.getValue()));
		user.setName(userName.toString());
		
		AgentServerSessionManager sessionManager = ctx.channel().attr(AgentServerChannelHandler.SESSION_MANAGER_ATTRIBUTE).getAndSet(null);
		AgentServerSession session = sessionManager.getSession(user);
		
		ctx.channel().attr(AgentServerChannelHandler.SESSION_ATTRIBUTE).set(session);
		
		S2CAnsCharactersListPacket ansCharactersListPacket = new S2CAnsCharactersListPacket();
		ansCharactersListPacket.process(ctx);
		
		ctx.writeAndFlush(ansCharactersListPacket);
	}
}
