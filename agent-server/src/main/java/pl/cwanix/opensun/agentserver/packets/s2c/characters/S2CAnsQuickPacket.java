package pl.cwanix.opensun.agentserver.packets.s2c.characters;

import io.netty.channel.ChannelHandlerContext;
import pl.cwanix.opensun.commonserver.packets.OutgoingPacket;
import pl.cwanix.opensun.commonserver.packets.Packet;
import pl.cwanix.opensun.commonserver.packets.PacketCategory;
import pl.cwanix.opensun.utils.datatypes.FixedLengthField;

@OutgoingPacket(category = PacketCategory.CHAR_INFO, type = (byte) 0xBE)
public class S2CAnsQuickPacket implements Packet {
	
	private FixedLengthField value;
	
	public S2CAnsQuickPacket() {
		value = new FixedLengthField(1);
	}

	@Override
	public void process(ChannelHandlerContext ctx) {
		// TODO Auto-generated method stub
		
	}

}
