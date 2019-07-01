package pl.cwanix.opensun.utils.datatypes;

import pl.cwanix.opensun.utils.bytes.BytesUtils;

public class FixedLengthField implements SUNDataType {

	private byte[] value;
	
	public FixedLengthField(int length) {
		this.value = new byte[length];
	}
	
	public FixedLengthField(int length, byte... bytes) {
		this.value = new byte[length];
		setValue(bytes);
	}
	
	public FixedLengthField(int length, String text) {
		this.value = new byte[length];
		setValue(text);
	}
	
	public FixedLengthField(int length, int value) {
		this.value = new byte[length];
		setValue(value);
	}
	
	public void setValue(String text) {
		setValue(text.getBytes());
	}
	
	public void setValue(byte... bytes) {
		for (int i = 0; i < this.value.length; i++) {
			if (i < bytes.length) {
				this.value[i] = bytes[i];
			} else {
				this.value[i] = 0x00;
			}
		}
	}
	
	public void setValue(int value) {
		setValue(BytesUtils.intToByteArray(value));
	}
	
	public int toInt() {
		return BytesUtils.byteArrayToInt(value);
	}
	
	public String toString() {
		return new String(BytesUtils.cutTail(value));
	}

	@Override
	public byte[] toByteArray() {
		return value;
	}
}
