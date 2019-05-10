package pl.cwanix.opensun.authserver.packet.c2s;

import io.netty.channel.ChannelHandlerContext;
import pl.cwanix.opensun.authserver.packet.Packet;

public abstract class ClientPacket extends Packet {

	public abstract void process(ChannelHandlerContext ctx);
}
