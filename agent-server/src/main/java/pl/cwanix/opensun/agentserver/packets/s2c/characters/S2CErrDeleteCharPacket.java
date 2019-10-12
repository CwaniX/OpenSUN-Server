package pl.cwanix.opensun.agentserver.packets.s2c.characters;

import org.apache.commons.lang3.ArrayUtils;
import pl.cwanix.opensun.commonserver.packets.Packet;
import pl.cwanix.opensun.commonserver.packets.PacketCategory;
import pl.cwanix.opensun.commonserver.packets.annotations.OutgoingPacket;
import pl.cwanix.opensun.utils.datatypes.FixedLengthField;

@OutgoingPacket(category = PacketCategory.CHARACTER, type = 0x71)
public class S2CErrDeleteCharPacket implements Packet {

	private FixedLengthField errorCode;
	
	public S2CErrDeleteCharPacket(int errorCode) {
		this.errorCode = new FixedLengthField(4, errorCode);
	}
	
	@Override
	public Object[] getOrderedFields() {
		return ArrayUtils.toArray(errorCode);
	}
}
