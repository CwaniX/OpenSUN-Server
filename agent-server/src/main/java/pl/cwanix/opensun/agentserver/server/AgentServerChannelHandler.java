package pl.cwanix.opensun.agentserver.server;

import org.springframework.web.client.RestTemplate;

import io.netty.channel.ChannelHandlerContext;
import io.netty.util.AttributeKey;
import lombok.RequiredArgsConstructor;
import pl.cwanix.opensun.agentserver.properties.AgentServerProperties;
import pl.cwanix.opensun.agentserver.server.session.AgentServerSession;
import pl.cwanix.opensun.commonserver.packets.ClientPacket;
import pl.cwanix.opensun.commonserver.server.SUNServerChannelHandler;

@RequiredArgsConstructor
public class AgentServerChannelHandler extends SUNServerChannelHandler {
	
	public static final AttributeKey<AgentServerSession> SESSION_ATTRIBUTE = AttributeKey.valueOf("session");
	public static final AttributeKey<RestTemplate> REST_TEMPLATE_ATTRIBUTE = AttributeKey.valueOf("rest_template");
	public static final AttributeKey<AgentServerProperties> PROPERIES_ATTRIBUTE = AttributeKey.valueOf("properties");
	
	private final RestTemplate restTemplate;
	private final AgentServerSession session;
	private final AgentServerProperties properties;
	
	@Override
	public void channelActive(ChannelHandlerContext ctx) {
		ctx.channel().attr(SESSION_ATTRIBUTE).set(session);
		ctx.channel().attr(REST_TEMPLATE_ATTRIBUTE).set(restTemplate);
		ctx.channel().attr(PROPERIES_ATTRIBUTE).set(properties);
	}

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) {
    	ClientPacket packet = (ClientPacket) msg;
    	packet.process(ctx);
    }
}
