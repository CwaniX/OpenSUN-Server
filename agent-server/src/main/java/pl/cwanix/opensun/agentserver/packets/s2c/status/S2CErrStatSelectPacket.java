package pl.cwanix.opensun.agentserver.packets.s2c.status;

import org.apache.commons.lang3.ArrayUtils;

import pl.cwanix.opensun.agentserver.server.context.AgentServerContext;
import pl.cwanix.opensun.commonserver.packets.annotations.OutgoingPacket;
import pl.cwanix.opensun.commonserver.packets.Packet;
import pl.cwanix.opensun.commonserver.packets.PacketCategory;
import pl.cwanix.opensun.utils.datatypes.FixedLengthField;

@OutgoingPacket(category = PacketCategory.STATUS, type = 0x7E)
public class S2CErrStatSelectPacket implements Packet<AgentServerContext> {
	
	private FixedLengthField attributeCode;
	private FixedLengthField errorCode;

	public S2CErrStatSelectPacket(byte attributeCode, int errorCode) {
		this.attributeCode = new FixedLengthField(1, attributeCode);
		this.errorCode = new FixedLengthField(4, errorCode);
	}
	
	@Override
	public Object[] getOrderedFields() {
		return ArrayUtils.toArray(attributeCode, errorCode);
	}
}
