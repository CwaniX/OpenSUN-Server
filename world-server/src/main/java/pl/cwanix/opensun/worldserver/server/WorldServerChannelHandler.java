package pl.cwanix.opensun.worldserver.server;

import org.springframework.web.client.RestTemplate;

import io.netty.channel.ChannelHandlerContext;
import io.netty.util.AttributeKey;
import lombok.RequiredArgsConstructor;
import pl.cwanix.opensun.commonserver.packets.Packet;
import pl.cwanix.opensun.commonserver.server.SUNServerChannelHandler;
import pl.cwanix.opensun.worldserver.properties.WorldServerProperties;

@RequiredArgsConstructor
public class WorldServerChannelHandler extends SUNServerChannelHandler {
	
	//public static final AttributeKey<WorldServerSession> SESSION_ATTRIBUTE = AttributeKey.valueOf("session");
	//public static final AttributeKey<WorldServerSessionManager> SESSION_MANAGER_ATTRIBUTE = AttributeKey.valueOf("session_manager");
	public static final AttributeKey<RestTemplate> REST_TEMPLATE_ATTRIBUTE = AttributeKey.valueOf("rest_template");
	public static final AttributeKey<WorldServerProperties> PROPERIES_ATTRIBUTE = AttributeKey.valueOf("properties");
	
	private final RestTemplate restTemplate;
	//private final WorldServerSessionManager sessionManager;
	private final WorldServerProperties properties;
	
	@Override
	public void channelActive(ChannelHandlerContext ctx) {
		//ctx.channel().attr(SESSION_MANAGER_ATTRIBUTE).set(sessionManager);
		ctx.channel().attr(REST_TEMPLATE_ATTRIBUTE).set(restTemplate);
		ctx.channel().attr(PROPERIES_ATTRIBUTE).set(properties);
	}

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) {
    	Packet packet = (Packet) msg;
    	packet.process(ctx);
    }
}
