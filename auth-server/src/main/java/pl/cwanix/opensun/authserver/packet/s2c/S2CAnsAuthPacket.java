package pl.cwanix.opensun.authserver.packet.s2c;

import pl.cwanix.opensun.commonserver.packets.ServerPacket;
import pl.cwanix.opensun.utils.bytes.BytesUtils;
import pl.cwanix.opensun.utils.packets.FixedLengthField;
import pl.cwanix.opensun.utils.packets.PacketHeader;

public class S2CAnsAuthPacket extends ServerPacket {
	
	private static final int INFO_MAX_LEN = 64;

	public static final PacketHeader PACKET_ID = new PacketHeader((byte) 0x33, (byte) 0x0E);
	
	private FixedLengthField result;
	private FixedLengthField info;
	
	public S2CAnsAuthPacket() {
		this.size = new byte[] { 0x43, 0x00 };
		this.result = new FixedLengthField(FixedLengthField.BYTE);
		this.info = new FixedLengthField(INFO_MAX_LEN);
	}

	public byte[] toByteArray() {
		return BytesUtils.mergeArrays(size, PACKET_ID.getValue(), result.getValue(), info.getValue());
	}
}
