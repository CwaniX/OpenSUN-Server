package pl.cwanix.opensun.worldserver.packets.c2s;

import io.netty.channel.ChannelHandlerContext;
import pl.cwanix.opensun.commonserver.packets.IncomingPacket;
import pl.cwanix.opensun.commonserver.packets.Packet;
import pl.cwanix.opensun.commonserver.packets.PacketCategory;
import pl.cwanix.opensun.utils.packets.PacketHeader;

@IncomingPacket(category = PacketCategory.CONNECTION, type = (byte) 0x3C)
public class C2S483CPacket extends Packet {

	@Override
	public void process(ChannelHandlerContext ctx) {
		// TODO Auto-generated method stub
		
	}

}
