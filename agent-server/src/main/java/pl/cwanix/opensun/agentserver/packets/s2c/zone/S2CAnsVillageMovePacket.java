package pl.cwanix.opensun.agentserver.packets.s2c.zone;

import org.apache.commons.lang3.ArrayUtils;
import pl.cwanix.opensun.commonserver.packets.Packet;
import pl.cwanix.opensun.commonserver.packets.PacketCategory;
import pl.cwanix.opensun.commonserver.packets.annotations.OutgoingPacket;
import pl.cwanix.opensun.utils.datatypes.FixedLengthField;

@OutgoingPacket(category = PacketCategory.ZONE, /*type = 0x6C*/ type=(byte) 0xCD)
public class S2CAnsVillageMovePacket implements Packet {

	
	public S2CAnsVillageMovePacket() { }
	
	@Override
	public Object[] getOrderedFields() {
		return ArrayUtils.EMPTY_OBJECT_ARRAY;
	}
}
