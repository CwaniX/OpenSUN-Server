package pl.cwanix.opensun.agentserver.server;

import io.netty.channel.ChannelHandlerContext;
import io.netty.util.AttributeKey;
import lombok.RequiredArgsConstructor;
import pl.cwanix.opensun.agentserver.server.context.AgentServerContext;
import pl.cwanix.opensun.agentserver.server.session.AgentServerSession;
import pl.cwanix.opensun.commonserver.packets.Packet;
import pl.cwanix.opensun.commonserver.server.SUNServerChannelHandler;

@RequiredArgsConstructor
public class AgentServerChannelHandler extends SUNServerChannelHandler {
	
	public static final AttributeKey<AgentServerSession> SESSION_ATTRIBUTE = AttributeKey.valueOf("session");
	
	private final AgentServerContext srv;

	@Override
	@SuppressWarnings("unchecked")
    public void channelRead(ChannelHandlerContext ctx, Object msg) {
    	Packet<AgentServerContext> packet = (Packet<AgentServerContext>) msg;
    	packet.process(ctx, srv);
    }
}
