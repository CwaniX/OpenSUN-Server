package pl.cwanix.opensun.agentserver.packets.s2c.characters;

import pl.cwanix.opensun.agentserver.server.context.AgentServerContext;
import pl.cwanix.opensun.commonserver.packets.annotations.OutgoingPacket;
import pl.cwanix.opensun.commonserver.packets.Packet;
import pl.cwanix.opensun.commonserver.packets.PacketCategory;

@OutgoingPacket(category = PacketCategory.CHAR_INFO, type = 0x07)
public class S2CAnsDeleteCharPacket implements Packet<AgentServerContext> {

	@Override
	public Object[] getOrderedFields() {
		return null;
	}
}
