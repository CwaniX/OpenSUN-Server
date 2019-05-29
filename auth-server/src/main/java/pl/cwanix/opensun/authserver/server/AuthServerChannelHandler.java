package pl.cwanix.opensun.authserver.server;

import io.netty.channel.ChannelHandlerContext;
import pl.cwanix.opensun.authserver.packet.s2c.S2CHelloPacket;
import pl.cwanix.opensun.authserver.server.session.AuthServerSession;
import pl.cwanix.opensun.commonserver.packets.ClientPacket;
import pl.cwanix.opensun.commonserver.server.SUNServerChannelHandler;

public class AuthServerChannelHandler extends SUNServerChannelHandler {
	
	private AuthServerSession session;
	
	@Override
	public void channelActive(ChannelHandlerContext ctx) throws Exception {
		session = new AuthServerSession();
		
		S2CHelloPacket packet = new S2CHelloPacket();
		packet.setEncKey(session.getEncKey());
	    
	    ctx.writeAndFlush(packet);
	}

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) {
    	ClientPacket packet = (ClientPacket) msg;
    	packet.setSession(session);
    	packet.process(ctx);
    }
}
