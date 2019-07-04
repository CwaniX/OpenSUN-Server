package pl.cwanix.opensun.agentserver.packets.structures;

import java.util.Arrays;

import pl.cwanix.opensun.commonserver.packets.PacketStructure;
import pl.cwanix.opensun.utils.datatypes.FixedLengthField;

public class RenderItemSlotPacketStructure implements PacketStructure {

	private FixedLengthField position;
	private RenderItemPartPacketStructure itemPart;
	
	public RenderItemSlotPacketStructure(byte[] value) {
		position = new FixedLengthField(1, value[0]);
		itemPart = new RenderItemPartPacketStructure(Arrays.copyOfRange(value, 1, value.length));
	}
}
