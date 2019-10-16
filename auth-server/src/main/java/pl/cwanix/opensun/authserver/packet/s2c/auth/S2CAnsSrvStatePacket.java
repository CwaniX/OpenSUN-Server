package pl.cwanix.opensun.authserver.packet.s2c.auth;

import pl.cwanix.opensun.commonserver.packets.Packet;
import pl.cwanix.opensun.commonserver.packets.PacketCategory;
import pl.cwanix.opensun.commonserver.packets.annotations.OutgoingPacket;
import pl.cwanix.opensun.utils.bytes.BytesUtils;
import pl.cwanix.opensun.utils.datatypes.PacketHeader;

@OutgoingPacket(category = PacketCategory.AUTH, type = 0x12)
public class S2CAnsSrvStatePacket implements Packet {

	public static final PacketHeader PACKET_ID = new PacketHeader((byte) 0x33, (byte) 0x12);
	
	private byte[] value;
	
	public S2CAnsSrvStatePacket() {
		this.value = new byte[] { 0x01, 0x31, (byte) 0xcf, (byte) 0xdf, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x01, 0x05, 0x01, (byte) 0xcc };
	}

	@Override
	public byte[] toByteArray() {
		return BytesUtils.mergeArrays(PACKET_ID.getValue(), value);
	}

	@Override
	public Object[] getOrderedFields() {
		return null;
	}
}
