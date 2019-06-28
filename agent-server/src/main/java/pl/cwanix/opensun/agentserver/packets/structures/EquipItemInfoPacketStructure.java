package pl.cwanix.opensun.agentserver.packets.structures;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import pl.cwanix.opensun.commonserver.packets.PacketStructure;
import pl.cwanix.opensun.utils.datatypes.FixedLengthField;

public class EquipItemInfoPacketStructure implements PacketStructure {
	
	private FixedLengthField count;
	private List<ItemSlotPacketStructure> slot;
	
	public EquipItemInfoPacketStructure(byte[] value) {
		count = new FixedLengthField(1, value[0]);
		slot = new ArrayList<>();
		
		for (int i = 0; i < value[0]; i++) {
			slot.add(new ItemSlotPacketStructure(Arrays.copyOfRange(value, 1 + i * 28, 29 + i * 28)));
		}
	}
}
