package pl.cwanix.opensun.authserver.packet.s2c.auth;

import org.apache.commons.lang3.ArrayUtils;
import pl.cwanix.opensun.commonserver.packets.Packet;
import pl.cwanix.opensun.commonserver.packets.PacketCategory;
import pl.cwanix.opensun.commonserver.packets.annotations.OutgoingPacket;
import pl.cwanix.opensun.utils.datatypes.FixedLengthField;

@OutgoingPacket(category = PacketCategory.AUTH, type = 0x1A)
public class S2CAnsSrvSelectPacket implements Packet {

	private FixedLengthField userId;
	private FixedLengthField unknownString;
	private FixedLengthField serverIp;
	private FixedLengthField serverPort;

	public S2CAnsSrvSelectPacket(int userId, String serverIp, int port) {
		this.userId = new FixedLengthField(4, userId);
		this.unknownString = new FixedLengthField(32, new byte[] { 0x30, 0x00, 0x20, 0x00, 0x00, 0x20, 0x00, 0x00, 0x20, (byte) 0x81, 0x07, 0x20, 0x42, 0x00, 0x20, 0x0f, 0x00, 0x20, 0x00, 0x00, 0x20, 0x00, 0x00, 0x20, 0x00, 0x00, 0x20, 0x0e, 0x00, 0x20, 0x07, 0x08 });
		this.serverIp = new FixedLengthField(32, serverIp);
		this.serverPort = new FixedLengthField(5, port);
	}
	
	@Override
	public Object[] getOrderedFields() {
		return ArrayUtils.toArray(userId, unknownString, serverIp, serverPort);
	}
}
