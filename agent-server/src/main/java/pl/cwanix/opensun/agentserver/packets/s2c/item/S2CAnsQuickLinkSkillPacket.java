package pl.cwanix.opensun.agentserver.packets.s2c.item;

import org.apache.commons.lang3.ArrayUtils;

import pl.cwanix.opensun.agentserver.server.context.AgentServerContext;
import pl.cwanix.opensun.commonserver.packets.annotations.OutgoingPacket;
import pl.cwanix.opensun.commonserver.packets.Packet;
import pl.cwanix.opensun.commonserver.packets.PacketCategory;
import pl.cwanix.opensun.utils.datatypes.FixedLengthField;

@OutgoingPacket(category = PacketCategory.ITEM, type = (byte) 0xF7)
public class S2CAnsQuickLinkSkillPacket implements Packet<AgentServerContext> {
	
	private FixedLengthField slotCode;
	private FixedLengthField position;
	
	public S2CAnsQuickLinkSkillPacket(int slotCode, byte position) {
		this.slotCode = new FixedLengthField(2, slotCode);
		this.position = new FixedLengthField(1, position);
	}
	
	@Override
	public Object[] getOrderedFields() {
		return ArrayUtils.toArray(slotCode, position);
	}
}
