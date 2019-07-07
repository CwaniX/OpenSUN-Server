package pl.cwanix.opensun.agentserver.packets.s2c.zone;

import pl.cwanix.opensun.commonserver.packets.OutgoingPacket;
import pl.cwanix.opensun.commonserver.packets.Packet;
import pl.cwanix.opensun.commonserver.packets.PacketCategory;
import pl.cwanix.opensun.utils.datatypes.FixedLengthField;

@OutgoingPacket(category = PacketCategory.ZONE, type = 0x6C)
public class S2CAnsVillageMovePacket implements Packet {
	
	private FixedLengthField moveType;
	private FixedLengthField villageMapCode;
	
	public S2CAnsVillageMovePacket(short mapCode, int type) {
		moveType = new FixedLengthField(1, type);
		villageMapCode = new FixedLengthField(4, mapCode);
	}
}
