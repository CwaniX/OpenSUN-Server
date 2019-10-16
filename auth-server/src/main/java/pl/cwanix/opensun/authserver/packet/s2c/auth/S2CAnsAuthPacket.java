package pl.cwanix.opensun.authserver.packet.s2c.auth;

import org.apache.commons.lang3.ArrayUtils;
import pl.cwanix.opensun.commonserver.packets.Packet;
import pl.cwanix.opensun.commonserver.packets.PacketCategory;
import pl.cwanix.opensun.commonserver.packets.annotations.OutgoingPacket;
import pl.cwanix.opensun.utils.datatypes.FixedLengthField;

@OutgoingPacket(category = PacketCategory.AUTH, type = 0x0E)
public class S2CAnsAuthPacket implements Packet {
	
	private FixedLengthField result;
	private FixedLengthField info;
	
	public S2CAnsAuthPacket(int resultCode) {
		this.result = new FixedLengthField(1, resultCode);
		this.info = new FixedLengthField(64);
	}
	
	@Override
	public Object[] getOrderedFields() {
		return ArrayUtils.toArray(result, info);
	}
}
