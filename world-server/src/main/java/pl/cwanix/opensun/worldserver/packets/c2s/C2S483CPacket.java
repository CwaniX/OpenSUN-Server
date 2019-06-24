package pl.cwanix.opensun.worldserver.packets.c2s;

import io.netty.channel.ChannelHandlerContext;
import pl.cwanix.opensun.commonserver.packets.IncomingPacket;
import pl.cwanix.opensun.commonserver.packets.Packet;
import pl.cwanix.opensun.utils.packets.PacketHeader;

@IncomingPacket
public class C2S483CPacket extends Packet {
	
	public static final PacketHeader PACKET_ID = new PacketHeader((byte) 0x48, (byte) 0x3C);

	@Override
	public void process(ChannelHandlerContext ctx) {
		// TODO Auto-generated method stub
		
	}

}
