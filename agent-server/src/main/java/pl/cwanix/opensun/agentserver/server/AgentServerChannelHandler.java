package pl.cwanix.opensun.agentserver.server;

import io.netty.channel.ChannelHandlerContext;
import pl.cwanix.opensun.commonserver.packets.ClientPacket;
import pl.cwanix.opensun.commonserver.server.SUNServerChannelHandler;

public class AgentServerChannelHandler extends SUNServerChannelHandler {

	/*@Override
	public void channelActive(ChannelHandlerContext ctx) throws Exception {
		//byte[] packet = new S2CHelloPacket().toByteArray();
		
		//ByteBuf buffer = ctx.alloc().buffer(packet.length);
	    //buffer.writeBytes(packet);
	    
	    //ctx.writeAndFlush(buffer);
	}*/

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) {
    	ClientPacket packet = (ClientPacket) msg;
    	packet.process(ctx);
    }
}
