package pl.cwanix.opensun.worldserver.packets.s2c;

import io.netty.channel.ChannelHandlerContext;
import pl.cwanix.opensun.commonserver.packets.OutgoingPacket;
import pl.cwanix.opensun.commonserver.packets.Packet;
import pl.cwanix.opensun.utils.packets.PacketHeader;

@OutgoingPacket
public class S2C486CPacket extends Packet {
	
	public static final PacketHeader PACKET_ID = new PacketHeader((byte) 0x48, (byte) 0x6C);

	@Override
	public void process(ChannelHandlerContext ctx) {
		// TODO Auto-generated method stub
		
	}

}
