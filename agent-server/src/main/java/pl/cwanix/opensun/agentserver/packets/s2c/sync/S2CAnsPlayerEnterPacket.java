package pl.cwanix.opensun.agentserver.packets.s2c.sync;

import io.netty.channel.ChannelHandlerContext;
import pl.cwanix.opensun.commonserver.packets.OutgoingPacket;
import pl.cwanix.opensun.commonserver.packets.Packet;
import pl.cwanix.opensun.commonserver.packets.PacketCategory;
import pl.cwanix.opensun.utils.datatypes.FixedLengthField;

@OutgoingPacket(category = PacketCategory.SYNC, type = (byte) 0x1F)
public class S2CAnsPlayerEnterPacket implements Packet {
	
	private FixedLengthField value;
	
	public S2CAnsPlayerEnterPacket() {
		value = new FixedLengthField(14, new byte[] { 0x00, 0x00, 0x50, (byte) 0xc2, 0x00, 0x00, (byte) 0xd8, (byte) 0xc1, (byte) 0xe5, (byte) 0xd9, (byte) 0xc6, (byte) 0xc1, 0x00, 0x00 });
	}

	@Override
	public void process(ChannelHandlerContext ctx) {
		// TODO Auto-generated method stub
		
	}

}
