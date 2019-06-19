package pl.cwanix.opensun.commonserver.packets;

import io.netty.channel.ChannelHandlerContext;
import pl.cwanix.opensun.utils.packets.PacketHeader;

public abstract class Packet {
	
	public static final PacketHeader PACKET_ID = new PacketHeader((byte) 0x00, (byte) 0x00);
	
	public abstract void process(ChannelHandlerContext ctx);
	public abstract byte[] toByteArray();
}
