package pl.cwanix.opensun.authserver.packet.s2c;

import lombok.Getter;
import pl.cwanix.opensun.commonserver.packets.ServerPacket;
import pl.cwanix.opensun.utils.bytes.BytesUtils;
import pl.cwanix.opensun.utils.packets.FixedLengthField;
import pl.cwanix.opensun.utils.packets.PacketHeader;

@Getter
public class S2CAnsSrvSelect extends ServerPacket {

	public static final PacketHeader PACKET_ID = new PacketHeader((byte) 0x33, (byte) 0x1A);

	private FixedLengthField userId;
	private FixedLengthField unknownString;
	private FixedLengthField serverIp;
	//private FixedLengthField serverPort;
	private FixedLengthField unknownValue;

	public S2CAnsSrvSelect() {
		this.size = new byte[] { 0x4b, 0x00 };
		this.userId = new FixedLengthField(FixedLengthField.DWORD, new byte[] { 0x21, 0x00, 0x00, 0x00 });
		this.unknownString = new FixedLengthField(32, new byte[] { 0x30, 0x00, 0x20, 0x00, 0x00, 0x20, 0x00, 0x00, 0x20, (byte) 0x81, 0x07, 0x20, 0x42, 0x00, 0x20, 0x0f, 0x00, 0x20, 0x00, 0x00, 0x20, 0x00, 0x00, 0x20, 0x00, 0x00, 0x20, 0x0e, 0x00, 0x20, 0x07, 0x08 });
		this.serverIp = new FixedLengthField(32, new byte[] { 0x31, 0x39, 0x32, 0x2e, 0x31, 0x36, 0x38, 0x2e, 0x30, 0x2e, 0x31, 0x36, 0x34 });
		//this.serverPort = new FixedLengthField(13);
		this.unknownValue = new FixedLengthField(5, new byte[] { 0x76, (byte) 0xad, 0x00, 0x00, 0x00 });
	}

	public byte[] toByteArray() {
		return BytesUtils.mergeArrays(size, PACKET_ID.getValue(), userId.getValue(), unknownString.getValue(),
				serverIp.getValue(), /*serverPort.getValue(),*/ unknownValue.getValue());
	}
}
