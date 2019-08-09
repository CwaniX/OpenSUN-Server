package pl.cwanix.opensun.agentserver.packets.s2c.characters;

import org.apache.commons.lang3.ArrayUtils;

import pl.cwanix.opensun.agentserver.server.context.AgentServerContext;
import pl.cwanix.opensun.commonserver.packets.OutgoingPacket;
import pl.cwanix.opensun.commonserver.packets.Packet;
import pl.cwanix.opensun.commonserver.packets.PacketCategory;
import pl.cwanix.opensun.utils.datatypes.FixedLengthField;

@OutgoingPacket(category = PacketCategory.CHAR_INFO, type = (byte) 0xBE)
public class S2CAnsQuickPacket implements Packet<AgentServerContext> {
	
	private FixedLengthField value;
	
	public S2CAnsQuickPacket() {
		value = new FixedLengthField(1);
	}

	@Override
	public Object[] getOrderedFields() {
		return ArrayUtils.toArray(value);
	}
}
