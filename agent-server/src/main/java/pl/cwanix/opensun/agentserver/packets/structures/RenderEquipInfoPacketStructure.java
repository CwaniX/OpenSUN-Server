package pl.cwanix.opensun.agentserver.packets.structures;

import java.util.List;

import pl.cwanix.opensun.commonserver.packets.PacketStructure;
import pl.cwanix.opensun.utils.datatypes.FixedLengthField;

public class RenderEquipInfoPacketStructure implements PacketStructure {

	private FixedLengthField count;
	private FixedLengthField objectKey;
	private List<RenderItemSlotPacketStructure> slot;
}
