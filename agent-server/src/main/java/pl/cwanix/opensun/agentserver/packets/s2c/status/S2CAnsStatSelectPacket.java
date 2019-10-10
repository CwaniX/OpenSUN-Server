package pl.cwanix.opensun.agentserver.packets.s2c.status;

import org.apache.commons.lang3.ArrayUtils;

import pl.cwanix.opensun.agentserver.server.context.AgentServerContext;
import pl.cwanix.opensun.commonserver.packets.annotations.OutgoingPacket;
import pl.cwanix.opensun.commonserver.packets.Packet;
import pl.cwanix.opensun.commonserver.packets.PacketCategory;
import pl.cwanix.opensun.utils.datatypes.FixedLengthField;

@OutgoingPacket(category = PacketCategory.STATUS, type = 0x7D)
public class S2CAnsStatSelectPacket implements Packet<AgentServerContext> {
	
	private FixedLengthField objectKey;
	private FixedLengthField attributeCode;
	private FixedLengthField value;

	public S2CAnsStatSelectPacket(byte attributeCode, int value) {
		this.objectKey = new FixedLengthField(4);
		this.attributeCode = new FixedLengthField(1, attributeCode);
		this.value = new FixedLengthField(4, value);
	}
	
	@Override
	public Object[] getOrderedFields() {
		return ArrayUtils.toArray(objectKey, attributeCode, value);
	}
}
