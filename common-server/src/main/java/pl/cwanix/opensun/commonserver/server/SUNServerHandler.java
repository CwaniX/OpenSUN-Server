package pl.cwanix.opensun.commonserver.server;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import pl.cwanix.opensun.commonserver.packets.ClientPacket;

public class SUNServerHandler extends ChannelInboundHandlerAdapter {

	@Override
	public void channelActive(ChannelHandlerContext ctx) throws Exception {
		/*byte[] helloPacket = new S2CHelloPacket().toByteArray();
		
		ByteBuf buffer = ctx.alloc().buffer(helloPacket.length);
	    buffer.writeBytes(helloPacket);
	    
	    ctx.writeAndFlush(buffer);*/
	}

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) {
    	ClientPacket packet = (ClientPacket) msg;
    	packet.process(ctx);
    }

    /**
     * Close the connection when an exception is raised.
     */
    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
        cause.printStackTrace();
        ctx.close();
    }
}
