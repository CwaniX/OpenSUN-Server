package pl.cwanix.opensun.agentserver.packets.structures;

import java.util.Arrays;

import pl.cwanix.opensun.commonserver.packets.PacketStructure;
import pl.cwanix.opensun.utils.bytes.BitField;
import pl.cwanix.opensun.utils.bytes.BytesUtils;

public class OptionPartPacketStructure implements PacketStructure {
	
	private static final BitField rankOption1 = new BitField(0b1111100000000000000000000000000000000000000000000000000000000000L);
	private static final BitField rankOption2 = new BitField(0b0000011111000000000000000000000000000000000000000000000000000000L);
	private static final BitField rankOption3 = new BitField(0b0000000000111110000000000000000000000000000000000000000000000000L);
	private static final BitField rankOption4 = new BitField(0b0000000000000001111100000000000000000000000000000000000000000000L);
	private static final BitField rankOption5 = new BitField(0b0000000000000000000011111000000000000000000000000000000000000000L);
	private static final BitField rankOption6 = new BitField(0b0000000000000000000000000111110000000000000000000000000000000000L);
	private static final BitField rankOption7 = new BitField(0b0000000000000000000000000000001111100000000000000000000000000000L);
	private static final BitField rankOption8 = new BitField(0b0000000000000000000000000000000000011111000000000000000000000000L);
	private static final BitField rankOption9 = new BitField(0b0000000000000000000000000000000000000000111110000000000000000000L);
	private static final BitField rank = new BitField(0b0000000000000000000000000000000000000000000001111000000000000000L);
	private static final BitField option = new BitField(0b0000000000000000000000000000000000000000000000000111000000000000L);
	private static final BitField enchant = new BitField(0b0000000000000000000000000000000000000000000000000000111100000000L);
	private static final BitField socketNum = new BitField(0b0000000000000000000000000000000000000000000000000000000000011000L);
	private static final BitField socketOption1 = new BitField(0b0000000000000000000000000000000000000000000000000000000000000111L);
	
	private static final BitField socketOption2 = new BitField(0b1111110000000000);
	private static final BitField socketOption3 = new BitField(0b0000001111110000);
	private static final BitField set = new BitField(0b0000000000001111);
	
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
	
	public long getRankOption1() {
		return rankOption1.getValue(bytes8);
	}
	
	public void setRankOption1(long value) {
		rankOption1.setValue(bytes8, value);
	}
	
	public long getRankOption2() {
		return rankOption2.getValue(bytes8);
	}
	
	public void setRankOption2(long value) {
		rankOption2.setValue(bytes8, value);
	}
	
	public long getRankOption3() {
		return rankOption3.getValue(bytes8);
	}
	
	public void setRankOption3(long value) {
		rankOption3.setValue(bytes8, value);
	}
	
	public long getRankOption4() {
		return rankOption4.getValue(bytes8);
	}
	
	public void setRankOption4(long value) {
		rankOption4.setValue(bytes8, value);
	}
	
	public long getRankOption5() {
		return rankOption5.getValue(bytes8);
	}
	
	public void setRankOption5(long value) {
		rankOption5.setValue(bytes8, value);
	}
	
	public long getRankOption6() {
		return rankOption6.getValue(bytes8);
	}
	
	public void setRankOption6(long value) {
		rankOption6.setValue(bytes8, value);
	}
	
	public long getRankOption7() {
		return rankOption7.getValue(bytes8);
	}
	
	public void setRankOption7(long value) {
		rankOption7.setValue(bytes8, value);
	}
	
	public long getRankOption8() {
		return rankOption8.getValue(bytes8);
	}
	
	public void setRankOption8(long value) {
		rankOption8.setValue(bytes8, value);
	}
	
	public long getRankOption9() {
		return rankOption9.getValue(bytes8);
	}
	
	public void setRankOption9(long value) {
		rankOption9.setValue(bytes8, value);
	}
	
	public long getRank() {
		return rank.getValue(bytes8);
	}
	
	public void setRank(long value) {
		rank.setValue(bytes8, value);
	}
	
	public long getOption() {
		return option.getValue(bytes8);
	}
	
	public void setOption(long value) {
		option.setValue(bytes8, value);
	}
	
	public long getEnchant() {
		return enchant.getValue(bytes8);
	}
	
	public void setEnchant(long value) {
		enchant.setValue(bytes8, value);
	}
	
	public long getSocketNum() {
		return socketNum.getValue(bytes8);
	}
	
	public void setSocketNum(long value) {
		socketNum.setValue(bytes8, value);
	}
	
	public long getSocketOption1() {
		return socketOption1.getValue(bytes8);
	}
	
	public void setSocketkOption1(long value) {
		socketOption1.setValue(bytes8, value);
	}
	
	public long getSocketOption2() {
		return socketOption2.getValue(bytes2);
	}
	
	public void setSocketkOption2(long value) {
		socketOption2.setValue(bytes2, value);
	}
	
	public long getSocketOption3() {
		return socketOption3.getValue(bytes2);
	}
	
	public void setSocketkOption3(long value) {
		socketOption3.setValue(bytes2, value);
	}
	
	public long getSet() {
		return set.getValue(bytes2);
	}
	
	public void setSet(long value) {
		set.setValue(bytes2, value);
	}
}
