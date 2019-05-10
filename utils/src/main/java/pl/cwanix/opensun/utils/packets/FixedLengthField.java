package pl.cwanix.opensun.utils.packets;

import lombok.Getter;

@Getter
public class FixedLengthField {
	
	public static final int BYTE = 1;
	public static final int WORD = 2;
	public static final int DWORD = 4;

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
}
