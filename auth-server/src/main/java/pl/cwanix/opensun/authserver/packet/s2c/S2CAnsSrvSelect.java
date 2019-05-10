package pl.cwanix.opensun.authserver.packet.s2c;

import lombok.Getter;
import pl.cwanix.opensun.utils.packets.FixedLengthField;
import pl.cwanix.opensun.utils.packets.PacketHeader;
import pl.cwanix.opensun.utils.packets.PacketUtils;

@Getter
public class S2CAnsSrvSelect extends ServerPacket {

	public static final PacketHeader PACKET_ID = new PacketHeader((byte) 0x33, (byte) 0x1A);

	private FixedLengthField userId;
	private FixedLengthField unknownString;
	private FixedLengthField serverIp;
	private FixedLengthField serverPort;
	private FixedLengthField unknownByte;
	private byte[] val = { 0x22, 0x4e, 0x00, 0x00, 0x00, 0x69, 0x75, 0x6b, 0x35, 0x65, 0x35, 0x71, 0x61, 0x00 }; 

	public S2CAnsSrvSelect() {
		this.size = new byte[] { 0x03, 0x00 };
		this.userId = new FixedLengthField(4, new byte[] { 0x00, 0x00, 0x00, 0x00 });
		this.unknownString = new FixedLengthField(32, new byte[] { 0x00 });
		this.serverIp = new FixedLengthField(32, new byte[] { 0x31, 0x37, 0x34, 0x2e, 0x33, 0x35, 0x2e, 0x31, 0x32, 0x32, 0x2e, 0x31, 0x35, 0x39 });
		//this.serverPort = new FixedLengthField(4, "20002");
		//this.unknownByte = new FixedLengthField(1, (byte) 0x00);
	}

	public byte[] toByteArray() {
		return PacketUtils.mergeArrays(size, PACKET_ID.getValue(), userId.getValue(), unknownString.getValue(),
				serverIp.getValue(), val)/*, serverPort.getValue(), unknownByte.getValue())*/;
	}
}
