package pl.cwanix.opensun.agentserver.packets.structures;

import java.util.Arrays;

import pl.cwanix.opensun.commonserver.packets.PacketStructure;
import pl.cwanix.opensun.utils.bytes.BytesUtils;
import pl.cwanix.opensun.utils.packets.FixedLengthField;

public class EquipItemInfoPacketStructure implements PacketStructure {
	
	private FixedLengthField count;
	private ItemSlotPacketStructure[] slot;
	
	public EquipItemInfoPacketStructure(byte[] value) {
		count = new FixedLengthField(1, value[0]);
		slot = new ItemSlotPacketStructure[value[0]];
		
		for (int i = 0; i < slot.length; i++) {
			slot[i] = new ItemSlotPacketStructure(Arrays.copyOfRange(value, 1 + i * 28, 29 + i * 28));
		}
	}

	@Override
	public byte[] toByteArray() {
		byte[] result = count.getValue();
		
		for (ItemSlotPacketStructure itemSlot : slot) {
			result = BytesUtils.mergeArrays(result, itemSlot.toByteArray());
		}
		
		return result;
	}

}
