package pl.cwanix.opensun.authserver.server;

import org.springframework.stereotype.Component;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import pl.cwanix.opensun.authserver.packet.c2s.ClientPacket;
import pl.cwanix.opensun.authserver.packet.s2c.S2CHelloPacket;

@ChannelHandler.Sharable
@Component
public class AuthServerHandler extends ChannelInboundHandlerAdapter {
	
	@Override
	public void channelActive(ChannelHandlerContext ctx) throws Exception {
		byte[] helloPacket = new S2CHelloPacket().toByteArray();
		
		//System.out.println(PacketUtils.byteArrayToHexString(helloPacket));
		
		ByteBuf buffer = ctx.alloc().buffer(helloPacket.length);
	    buffer.writeBytes(helloPacket);
	    
	    ctx.writeAndFlush(buffer);
	}

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) {
    	ClientPacket packet = (ClientPacket) msg;
    	packet.process(ctx);
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
        // Close the connection when an exception is raised.
        cause.printStackTrace();
        ctx.close();
    }
}
