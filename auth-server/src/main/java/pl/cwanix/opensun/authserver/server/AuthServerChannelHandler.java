package pl.cwanix.opensun.authserver.server;

import org.springframework.web.client.RestTemplate;

import io.netty.channel.ChannelHandlerContext;
import lombok.RequiredArgsConstructor;
import pl.cwanix.opensun.authserver.packet.s2c.S2CHelloPacket;
import pl.cwanix.opensun.authserver.server.session.AuthServerSession;
import pl.cwanix.opensun.commonserver.packets.ClientPacket;
import pl.cwanix.opensun.commonserver.server.SUNServerChannelHandler;

@RequiredArgsConstructor
public class AuthServerChannelHandler extends SUNServerChannelHandler {
	
	private final RestTemplate restTemplate;
	private final AuthServerSession session;
	
	@Override
	public void channelActive(ChannelHandlerContext ctx) throws Exception {
		ctx.channel().attr(SUNServerChannelHandler.SESSION_ATTRIBUTE).set(session);
		ctx.channel().attr(SUNServerChannelHandler.REST_TEMPLATE_ATTRIBUTE).set(restTemplate);
		
		S2CHelloPacket packet = new S2CHelloPacket();
		packet.process(ctx);
		
		ctx.writeAndFlush(packet);
	}

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) {
    	ClientPacket packet = (ClientPacket) msg;
    	packet.process(ctx);
    }
}
