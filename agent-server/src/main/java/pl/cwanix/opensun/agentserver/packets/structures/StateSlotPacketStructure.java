package pl.cwanix.opensun.agentserver.packets.structures;

import java.util.Arrays;

import org.apache.commons.lang3.ArrayUtils;

import pl.cwanix.opensun.commonserver.packets.PacketStructure;
import pl.cwanix.opensun.utils.datatypes.FixedLengthField;

@SuppressWarnings("checkstyle:MagicNumber")
public class StateSlotPacketStructure implements PacketStructure {
	
	private FixedLengthField slotCode;
	private FixedLengthField time;

	public StateSlotPacketStructure(byte[] value) {
		this.slotCode = new FixedLengthField(2, Arrays.copyOfRange(value, 0, 2));
		this.slotCode = new FixedLengthField(4, Arrays.copyOfRange(value, 2, 6));
	}
	
	@Override
	public Object[] getOrderedFields() {
		return ArrayUtils.toArray(slotCode, time);
	}
}
