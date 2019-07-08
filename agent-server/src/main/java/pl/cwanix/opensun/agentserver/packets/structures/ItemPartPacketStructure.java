package pl.cwanix.opensun.agentserver.packets.structures;

import org.apache.commons.lang3.ArrayUtils;

import pl.cwanix.opensun.commonserver.packets.PacketStructure;
import pl.cwanix.opensun.utils.datatypes.FixedLengthField;

public class ItemPartPacketStructure implements PacketStructure {
	
	private FixedLengthField code;
	private FixedLengthField durability;
	private FixedLengthField serial;
	
	public ItemPartPacketStructure(byte[] value) {
		code = new FixedLengthField(2, value[0], value[1]);
		durability = new FixedLengthField(1, value[2]);
		serial = new FixedLengthField(4, value[3], value[4], value[5], value[6]);
	}
	
	@Override
	public Object[] getOrderedFields() {
		return ArrayUtils.toArray(code, durability, serial);
	}
}
