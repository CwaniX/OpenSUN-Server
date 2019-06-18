package pl.cwanix.opensun.agentserver.packets.structures;

import java.util.Arrays;

import pl.cwanix.opensun.commonserver.packets.PacketStructure;
import pl.cwanix.opensun.utils.bytes.BitField;
import pl.cwanix.opensun.utils.bytes.BytesUtils;

public class OptionPartPacketStructure implements PacketStructure {
	
	private final BitField rankOption1 = new BitField(0b1111100000000000000000000000000000000000000000000000000000000000L);
	private final BitField rankOption2 = new BitField(0b0000011111000000000000000000000000000000000000000000000000000000L);
	private final BitField rankOption3 = new BitField(0b0000000000111110000000000000000000000000000000000000000000000000L);
	private final BitField rankOption4 = new BitField(0b0000000000000001111100000000000000000000000000000000000000000000L);
	private final BitField rankOption5 = new BitField(0b0000000000000000000011111000000000000000000000000000000000000000L);
	private final BitField rankOption6 = new BitField(0b0000000000000000000000000111110000000000000000000000000000000000L);
	private final BitField rankOption7 = new BitField(0b0000000000000000000000000000001111100000000000000000000000000000L);
	private final BitField rankOption8 = new BitField(0b0000000000000000000000000000000000011111000000000000000000000000L);
	private final BitField rankOption9 = new BitField(0b0000000000000000000000000000000000000000111110000000000000000000L);
	private final BitField rank = new BitField(0b0000000000000000000000000000000000000000000001111000000000000000L);
	private final BitField option = new BitField(0b0000000000000000000000000000000000000000000000000111000000000000L);
	private final BitField enchant = new BitField(0b0000000000000000000000000000000000000000000000000000111100000000L);
	private final BitField socketNum = new BitField(0b0000000000000000000000000000000000000000000000000000000000011000L);
	private final BitField socketOption1 = new BitField(0b0000000000000000000000000000000000000000000000000000000000000111L);
	
	private final BitField socketOption2 = new BitField(0b1111110000000000);
	private final BitField socketOption3 = new BitField(0b0000001111110000);
	private final BitField set = new BitField(0b0000000000001111);
	
	private long bytes8;
	private short bytes2;
	private byte[] unknownValue = { (byte) 0xcc, (byte) 0xcc, (byte) 0xcc, (byte) 0xcc, (byte) 0xcc, (byte) 0xcc, (byte) 0xcc, (byte) 0xcc, (byte) 0xcc, (byte) 0xcc };
	
	public OptionPartPacketStructure(byte[] value) {
		bytes8 = BytesUtils.byteArrayToLong(Arrays.copyOfRange(value, 0, 8));
		bytes2 = BytesUtils.byteArrayToShort(Arrays.copyOfRange(value, 8, 11));
	}
	
	@Override
	public byte[] toByteArray() {
		byte[] bytes8array = BytesUtils.longToByteArray(bytes8);
		byte[] bytes2array = BytesUtils.shortToByteArray(bytes2);

		return BytesUtils.mergeArrays(bytes8array, bytes2array, unknownValue);
	}
}
