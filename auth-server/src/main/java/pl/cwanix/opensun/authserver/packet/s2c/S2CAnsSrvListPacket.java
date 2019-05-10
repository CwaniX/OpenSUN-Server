package pl.cwanix.opensun.authserver.packet.s2c;

import pl.cwanix.opensun.utils.packets.PacketHeader;
import pl.cwanix.opensun.utils.packets.PacketUtils;

public class S2CAnsSrvListPacket extends ServerPacket {

	public static final PacketHeader PACKET_ID = new PacketHeader((byte) 0x33, (byte) 0x11);
	
	private byte[] value;
	
	public S2CAnsSrvListPacket() {
		this.size = new byte[] { 0x27, 0x00 };
		this.value = new byte[] { 0x01, 0x47, 0x6C, 0x6F, 0x62, 0x61, 0x6C, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x01, 0x00, 0x01,
				00, 00, 51, 18, 01, 67, 104,
				97, 110, 110, 101, 108, 32, 49, 00, 00, 00, 00, 00, 00, 00, 00, 00,
				00, 00, 00, 00, 00, 00, 00, 00, 00, 00, 00, 00, 00, 00, 00, 01,
				01, 01, 01};
	}

	public byte[] toByteArray() {
		return PacketUtils.mergeArrays(size, PACKET_ID.getValue(), value);
	}
}
