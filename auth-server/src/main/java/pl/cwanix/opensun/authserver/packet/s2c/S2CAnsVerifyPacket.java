package pl.cwanix.opensun.authserver.packet.s2c;

import lombok.Getter;
import pl.cwanix.opensun.utils.packets.FixedLengthField;
import pl.cwanix.opensun.utils.packets.PacketHeader;
import pl.cwanix.opensun.utils.packets.PacketUtils;

@Getter
public class S2CAnsVerifyPacket extends ServerPacket {

	public static final PacketHeader PACKET_ID = new PacketHeader((byte) 0x33, (byte) 0x02);
	
	private FixedLengthField result;
	
	public S2CAnsVerifyPacket() {
		this.size = new byte[] { 0x03, 0x00 };
		this.result = new FixedLengthField(FixedLengthField.BYTE, (byte) 0x00);
	}
	
	public byte[] toByteArray() {
		return PacketUtils.mergeArrays(size, PACKET_ID.getValue(), result.getValue());
	}
}
