package pl.cwanix.opensun.authserver.server;

import io.netty.channel.ChannelHandlerContext;
import io.netty.util.AttributeKey;
import lombok.RequiredArgsConstructor;
import pl.cwanix.opensun.authserver.packet.s2c.S2CAnsHelloPacket;
import pl.cwanix.opensun.authserver.server.context.AuthServerContext;
import pl.cwanix.opensun.authserver.server.session.AuthServerSession;
import pl.cwanix.opensun.commonserver.packets.Packet;
import pl.cwanix.opensun.commonserver.server.SUNServerChannelHandler;

@RequiredArgsConstructor
public class AuthServerChannelHandler extends SUNServerChannelHandler {
	
	public static final AttributeKey<AuthServerSession> SESSION_ATTRIBUTE = AttributeKey.valueOf("session");
	
	private final AuthServerContext srv;
	
	@Override
	public void channelActive(ChannelHandlerContext ctx) throws Exception {
		ctx.channel().attr(SESSION_ATTRIBUTE).set(srv.getSessionManager().startNewSession(null));
		
		S2CAnsHelloPacket packet = new S2CAnsHelloPacket();
		packet.process(ctx, srv);
		
		ctx.writeAndFlush(packet);
	}

	@Override
	@SuppressWarnings("unchecked")
    public void channelRead(ChannelHandlerContext ctx, Object msg) {
    	Packet<AuthServerContext> packet = (Packet<AuthServerContext>) msg;
    	packet.process(ctx, srv);
    }
}
