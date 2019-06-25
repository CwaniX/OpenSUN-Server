package pl.cwanix.opensun.authserver.server;

import org.springframework.web.client.RestTemplate;

import io.netty.channel.ChannelHandlerContext;
import io.netty.util.AttributeKey;
import lombok.RequiredArgsConstructor;
import pl.cwanix.opensun.authserver.packet.s2c.S2CHelloPacket;
import pl.cwanix.opensun.authserver.properties.AuthServerProperties;
import pl.cwanix.opensun.authserver.server.session.AuthServerSession;
import pl.cwanix.opensun.authserver.server.session.AuthServerSessionManager;
import pl.cwanix.opensun.commonserver.packets.Packet;
import pl.cwanix.opensun.commonserver.server.SUNServerChannelHandler;

@RequiredArgsConstructor
public class AuthServerChannelHandler extends SUNServerChannelHandler {
	
	public static final AttributeKey<AuthServerSession> SESSION_ATTRIBUTE = AttributeKey.valueOf("session");
	public static final AttributeKey<RestTemplate> REST_TEMPLATE_ATTRIBUTE = AttributeKey.valueOf("rest_template");
	public static final AttributeKey<AuthServerProperties> PROPERIES_ATTRIBUTE = AttributeKey.valueOf("properties");
	
	private final RestTemplate restTemplate;
	private final AuthServerSessionManager sessionManager;
	private final AuthServerProperties properties;
	
	@Override
	public void channelActive(ChannelHandlerContext ctx) throws Exception {		
		ctx.channel().attr(SESSION_ATTRIBUTE).set(sessionManager.startNewSession(null));
		ctx.channel().attr(REST_TEMPLATE_ATTRIBUTE).set(restTemplate);
		ctx.channel().attr(PROPERIES_ATTRIBUTE).set(properties);
		
		S2CHelloPacket packet = new S2CHelloPacket();
		packet.process(ctx);
		
		ctx.writeAndFlush(packet);
	}

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) {
    	Packet packet = (Packet) msg;
    	packet.process(ctx);
    }
}
