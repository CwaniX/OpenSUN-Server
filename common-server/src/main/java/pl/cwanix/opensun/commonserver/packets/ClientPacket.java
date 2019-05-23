package pl.cwanix.opensun.commonserver.packets;

import io.netty.channel.ChannelHandlerContext;

public abstract class ClientPacket extends Packet {

	public abstract void process(ChannelHandlerContext ctx);
}
