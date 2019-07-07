package pl.cwanix.opensun.authserver.packet.s2c;

import pl.cwanix.opensun.commonserver.packets.OutgoingPacket;
import pl.cwanix.opensun.commonserver.packets.Packet;
import pl.cwanix.opensun.commonserver.packets.PacketCategory;
import pl.cwanix.opensun.utils.datatypes.FixedLengthField;

@OutgoingPacket(category = PacketCategory.AUTH, type = 0x02)
public class S2CAnsVerifyPacket implements Packet {
	
	private FixedLengthField result;
	
	public S2CAnsVerifyPacket() {
		this.result = new FixedLengthField(1, (byte) 0x00);
	}
}
