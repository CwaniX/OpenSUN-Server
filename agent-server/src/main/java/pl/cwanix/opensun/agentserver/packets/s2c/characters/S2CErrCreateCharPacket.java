package pl.cwanix.opensun.agentserver.packets.s2c.characters;

import org.apache.commons.lang3.ArrayUtils;

import pl.cwanix.opensun.agentserver.server.context.AgentServerContext;
import pl.cwanix.opensun.commonserver.packets.annotations.OutgoingPacket;
import pl.cwanix.opensun.commonserver.packets.Packet;
import pl.cwanix.opensun.commonserver.packets.PacketCategory;
import pl.cwanix.opensun.utils.datatypes.FixedLengthField;

@OutgoingPacket(category = PacketCategory.CHAR_INFO, type = (byte) 0x71)
public class S2CErrCreateCharPacket implements Packet<AgentServerContext> {
	
	private FixedLengthField errorCode;
	
	public S2CErrCreateCharPacket() {
		errorCode = new FixedLengthField(4);
	}

	@Override
	public Object[] getOrderedFields() {
		return ArrayUtils.toArray(errorCode);
	}
}
