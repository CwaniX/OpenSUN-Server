package pl.cwanix.opensun.agentserver.packets.structures;

import lombok.Getter;
import lombok.Setter;
import pl.cwanix.opensun.commonserver.packets.PacketStructure;
import pl.cwanix.opensun.utils.bytes.BytesUtils;
import pl.cwanix.opensun.utils.packets.FixedLengthField;

@Getter
@Setter
public class ItemPartPacketStructure implements PacketStructure {
	
	private FixedLengthField code;
	private FixedLengthField durability;
	private FixedLengthField serial;
	
	public ItemPartPacketStructure(byte[] value) {
		code = new FixedLengthField(2);
		durability = new FixedLengthField(1);
		serial = new FixedLengthField(4);
	}

	@Override
	public byte[] toByteArray() {
		return BytesUtils.mergeArrays(code.getValue(), durability.getValue(), serial.getValue());
	}
}
