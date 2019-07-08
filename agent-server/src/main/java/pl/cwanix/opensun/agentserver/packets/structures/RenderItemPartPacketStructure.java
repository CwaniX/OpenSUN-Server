package pl.cwanix.opensun.agentserver.packets.structures;

import org.apache.commons.lang3.ArrayUtils;

import pl.cwanix.opensun.commonserver.packets.PacketStructure;
import pl.cwanix.opensun.utils.datatypes.FixedLengthField;

public class RenderItemPartPacketStructure implements PacketStructure {

	private FixedLengthField code;
	private FixedLengthField enchant;
	private FixedLengthField durability;
	
	public RenderItemPartPacketStructure(byte[] value) {
		code = new FixedLengthField(2, value[0], value[1]);
		enchant = new FixedLengthField(1, value[2]);
		durability = new FixedLengthField(1, value[3]);
	}
	
	@Override
	public Object[] getOrderedFields() {
		return ArrayUtils.toArray(code, enchant, durability);
	}
}
