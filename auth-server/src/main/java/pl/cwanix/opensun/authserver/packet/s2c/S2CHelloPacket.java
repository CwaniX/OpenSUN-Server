package pl.cwanix.opensun.authserver.packet.s2c;

import lombok.Getter;
import pl.cwanix.opensun.commonserver.packets.ServerPacket;
import pl.cwanix.opensun.utils.bytes.BytesUtils;
import pl.cwanix.opensun.utils.packets.FixedLengthField;
import pl.cwanix.opensun.utils.packets.PacketHeader;

@Getter
public class S2CHelloPacket extends ServerPacket {

	private static final int INFO_MAX_LEN = 64;
	
	public static final PacketHeader PACKET_ID = new PacketHeader((byte) 0x33, (byte) 0x00);
	
	private FixedLengthField serverInfo;
	private FixedLengthField encKey;
	
	public S2CHelloPacket() {
		this.size = new byte[] { 0x46, 0x00 };
		this.serverInfo = new FixedLengthField(INFO_MAX_LEN);
		this.encKey = new FixedLengthField(FixedLengthField.DWORD);
	}
	
	public byte[] toByteArray() {
		return BytesUtils.mergeArrays(size, PACKET_ID.getValue(), serverInfo.getValue(), encKey.getValue());
	}
	
	public void setEncKey(byte[] key) {
		encKey.setValue(key);
	}
}
