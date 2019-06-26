package pl.cwanix.opensun.agentserver.packets.s2c.connection;

import io.netty.channel.ChannelHandlerContext;
import pl.cwanix.opensun.commonserver.packets.OutgoingPacket;
import pl.cwanix.opensun.commonserver.packets.Packet;
import pl.cwanix.opensun.commonserver.packets.PacketCategory;
import pl.cwanix.opensun.utils.packets.FixedLengthField;

@OutgoingPacket(category = PacketCategory.CONNECTION, type = (byte) 0x83)
public class S2CAnsEnterVillagePacket implements Packet {
	
	private FixedLengthField value;
	
	public S2CAnsEnterVillagePacket() {
		value = new FixedLengthField(8, new byte[] { 0x10, 0x02, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00 });
	}

	@Override
	public void process(ChannelHandlerContext ctx) {
		// TODO Auto-generated method stub
		
	}

}
