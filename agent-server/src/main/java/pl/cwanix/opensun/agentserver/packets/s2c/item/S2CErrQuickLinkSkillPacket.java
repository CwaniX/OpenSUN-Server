package pl.cwanix.opensun.agentserver.packets.s2c.item;

import org.apache.commons.lang3.ArrayUtils;

import pl.cwanix.opensun.agentserver.server.context.AgentServerContext;
import pl.cwanix.opensun.commonserver.packets.annotations.OutgoingPacket;
import pl.cwanix.opensun.commonserver.packets.Packet;
import pl.cwanix.opensun.commonserver.packets.PacketCategory;
import pl.cwanix.opensun.utils.datatypes.FixedLengthField;

@OutgoingPacket(category = PacketCategory.ITEM, type = (byte) 0x10)
public class S2CErrQuickLinkSkillPacket implements Packet<AgentServerContext> {

	private FixedLengthField errorCode;
	
	public S2CErrQuickLinkSkillPacket(int errorCode) {
		this.errorCode = new FixedLengthField(4, errorCode);
	}
	
	@Override
	public Object[] getOrderedFields() {
		return ArrayUtils.toArray(errorCode);
	}
}
