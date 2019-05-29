package pl.cwanix.opensun.commonserver.packets;

import io.netty.channel.ChannelHandlerContext;

public abstract class Packet {
	
	public abstract void process(ChannelHandlerContext ctx);
}
