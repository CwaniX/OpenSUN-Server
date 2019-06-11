package pl.cwanix.opensun.agentserver.packets.structures;

import lombok.Getter;
import lombok.Setter;
import pl.cwanix.opensun.commonserver.packets.PacketStructure;
import pl.cwanix.opensun.utils.bytes.BytesUtils;

@Getter
@Setter
public class ItemStreamPacketStructure implements PacketStructure {

	private ItemPartPacketStructure itemPart;
	private OptionPartPacketStructure optionPart;
	
	@Override
	public byte[] toByteArray() {
		return BytesUtils.mergeArrays(itemPart.toByteArray(), optionPart.toByteArray());
	}
}
