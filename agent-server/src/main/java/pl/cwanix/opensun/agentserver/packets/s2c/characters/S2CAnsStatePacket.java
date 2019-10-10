package pl.cwanix.opensun.agentserver.packets.s2c.characters;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.ArrayUtils;

import pl.cwanix.opensun.agentserver.packets.structures.StateSlotPacketStructure;
import pl.cwanix.opensun.agentserver.server.context.AgentServerContext;
import pl.cwanix.opensun.commonserver.packets.annotations.OutgoingPacket;
import pl.cwanix.opensun.commonserver.packets.Packet;
import pl.cwanix.opensun.commonserver.packets.PacketCategory;
import pl.cwanix.opensun.utils.datatypes.FixedLengthField;

@OutgoingPacket(category = PacketCategory.CHAR_INFO, type = (byte) 0xDB)
public class S2CAnsStatePacket implements Packet<AgentServerContext> {

	private FixedLengthField count;
	private List<StateSlotPacketStructure> slot;
	
	public S2CAnsStatePacket() {
		this.count = new FixedLengthField(1, 0x02);
		this.slot = new ArrayList<>();
		this.slot.add(new StateSlotPacketStructure(new byte[] { 0x01, 0x00, (byte) 0xe8, 0x03, 0x00, 0x00 }));
		this.slot.add(new StateSlotPacketStructure(new byte[] { 0x02, 0x00, (byte) 0xe8, 0x03, 0x00, 0x00 }));
	}
	
	@Override
	public Object[] getOrderedFields() {
		return ArrayUtils.toArray(count, slot);
	}
}
