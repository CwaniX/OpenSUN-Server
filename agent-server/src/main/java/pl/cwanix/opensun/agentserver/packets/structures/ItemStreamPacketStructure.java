package pl.cwanix.opensun.agentserver.packets.structures;

import lombok.Getter;
import lombok.Setter;
import pl.cwanix.opensun.commonserver.packets.PacketStructure;

@Getter
@Setter
public class ItemStreamPacketStructure implements PacketStructure {

	private ItemPartPacketStructure itemPart; //7
	private OptionPartPacketStructure optionPart; //20
	
	@Override
	public byte[] toByteArray() {
		// TODO Auto-generated method stub
		return null;
	}
}
