package pl.cwanix.opensun.agentserver.packets.structures;

import lombok.Getter;
import lombok.Setter;
import pl.cwanix.opensun.commonserver.packets.PacketStructure;
import pl.cwanix.opensun.utils.packets.FixedLengthField;

@Getter
@Setter
public class EquipItemInfoPacketStructure implements PacketStructure {
	
	private FixedLengthField count; //1
	private ItemSlotPacketStructure[] slot; //17

	@Override
	public byte[] toByteArray() {
		// TODO Auto-generated method stub
		return null;
	}

}
