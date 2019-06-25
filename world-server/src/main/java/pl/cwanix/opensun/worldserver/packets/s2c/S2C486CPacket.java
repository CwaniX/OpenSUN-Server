package pl.cwanix.opensun.worldserver.packets.s2c;

import io.netty.channel.ChannelHandlerContext;
import pl.cwanix.opensun.commonserver.packets.OutgoingPacket;
import pl.cwanix.opensun.commonserver.packets.Packet;
import pl.cwanix.opensun.commonserver.packets.PacketCategory;
import pl.cwanix.opensun.utils.packets.PacketHeader;

@OutgoingPacket(category = PacketCategory.CONNECTION, type = (byte) 0x6C)
public class S2C486CPacket extends Packet {

	@Override
	public void process(ChannelHandlerContext ctx) {
		// TODO Auto-generated method stub
		
	}

}
