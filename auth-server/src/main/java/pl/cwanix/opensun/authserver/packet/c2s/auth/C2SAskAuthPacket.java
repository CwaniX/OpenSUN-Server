package pl.cwanix.opensun.authserver.packet.c2s.auth;

import lombok.Getter;
import pl.cwanix.opensun.commonserver.packets.Packet;
import pl.cwanix.opensun.commonserver.packets.PacketCategory;
import pl.cwanix.opensun.commonserver.packets.annotations.IncomingPacket;
import pl.cwanix.opensun.utils.datatypes.FixedLengthField;

import java.util.Arrays;

@Getter
@IncomingPacket(category = PacketCategory.AUTH, type = 0x03)
public class C2SAskAuthPacket implements Packet {
	
	private FixedLengthField unknown1;
	private FixedLengthField name;
	private FixedLengthField unknown2;
	private FixedLengthField password;
	private FixedLengthField unknown3;
	
	public C2SAskAuthPacket(byte[] value) {
		this.unknown1 = new FixedLengthField(4, Arrays.copyOfRange(value, 0, 4));
		/*this.name = new FixedLengthField(50, Arrays.copyOfRange(value, 4, 54));
		this.unknown2 = new FixedLengthField(1, value[54]);
		this.password = new FixedLengthField(16, Arrays.copyOfRange(value, 55, 71));
		this.unknown3 = new FixedLengthField(8, Arrays.copyOfRange(value, 71, value.length));*/

		this.name = new FixedLengthField(50, Arrays.copyOfRange(value, 4, 20));
	}
}
