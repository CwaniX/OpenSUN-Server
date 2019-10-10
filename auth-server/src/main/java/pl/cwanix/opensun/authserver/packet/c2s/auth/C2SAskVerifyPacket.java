package pl.cwanix.opensun.authserver.packet.c2s.auth;

import pl.cwanix.opensun.commonserver.packets.Packet;
import pl.cwanix.opensun.commonserver.packets.PacketCategory;
import pl.cwanix.opensun.commonserver.packets.annotations.IncomingPacket;
import pl.cwanix.opensun.utils.datatypes.FixedLengthField;

import java.util.Arrays;

@IncomingPacket(category = PacketCategory.AUTH, type = 0x01)
public class C2SAskVerifyPacket implements Packet {
	
	private FixedLengthField clientVersion;
	private FixedLengthField clientIpAddress;
	
	public C2SAskVerifyPacket(byte[] value) {
		this.clientVersion = new FixedLengthField(4, Arrays.copyOfRange(value, 0, 4));
		this.clientIpAddress = new FixedLengthField(16, Arrays.copyOfRange(value, 4, value.length));
	}
}
