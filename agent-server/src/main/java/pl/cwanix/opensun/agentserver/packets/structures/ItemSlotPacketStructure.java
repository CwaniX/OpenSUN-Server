package pl.cwanix.opensun.agentserver.packets.structures;

import lombok.Getter;
import lombok.Setter;
import pl.cwanix.opensun.commonserver.packets.PacketStructure;
import pl.cwanix.opensun.utils.packets.FixedLengthField;

@Getter
@Setter
public class ItemSlotPacketStructure implements PacketStructure {
	
	private FixedLengthField position; //1
	private ItemStreamPacketStructure stream;

	@Override
	public byte[] toByteArray() {
		// TODO Auto-generated method stub
		return null;
	}
}
