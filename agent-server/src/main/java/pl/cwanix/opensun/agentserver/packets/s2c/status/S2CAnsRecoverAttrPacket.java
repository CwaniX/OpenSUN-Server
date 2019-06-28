package pl.cwanix.opensun.agentserver.packets.s2c.status;

import io.netty.channel.ChannelHandlerContext;
import pl.cwanix.opensun.commonserver.packets.OutgoingPacket;
import pl.cwanix.opensun.commonserver.packets.Packet;
import pl.cwanix.opensun.commonserver.packets.PacketCategory;
import pl.cwanix.opensun.utils.datatypes.FixedLengthField;

@OutgoingPacket(category = PacketCategory.STATUS, type = 0x10)
public class S2CAnsRecoverAttrPacket implements Packet {
	
	private FixedLengthField value;
	
	public S2CAnsRecoverAttrPacket() {
		value = new FixedLengthField(12,
				new byte[] { 0x21, 0x00, 0x00, 0x00, (byte) 0x9e, 0x08, 0x00, 0x00,
						(byte) 0x9e, 0x08, 0x00, 0x00 });
	}

	@Override
	public void process(ChannelHandlerContext ctx) {
		// TODO Auto-generated method stub
		
	}

}
