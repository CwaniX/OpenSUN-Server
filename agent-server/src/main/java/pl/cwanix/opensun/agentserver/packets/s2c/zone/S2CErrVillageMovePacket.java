package pl.cwanix.opensun.agentserver.packets.s2c.zone;

import pl.cwanix.opensun.commonserver.packets.Packet;
import pl.cwanix.opensun.commonserver.packets.PacketCategory;
import pl.cwanix.opensun.commonserver.packets.annotations.OutgoingPacket;

@OutgoingPacket(category = PacketCategory.ZONE, type = 0x6D) //TODO: ?
public class S2CErrVillageMovePacket implements Packet {

	public S2CErrVillageMovePacket() {
	}

	@Override
	public Object[] getOrderedFields() {
		return null;
	}
}
