package pl.cwanix.opensun.utils.encryption;

import java.util.Arrays;

import pl.cwanix.opensun.utils.bytes.BytesUtils;

public class TEA {
	
	private static final int DELTA = 0x9E3779B9;
	
	private TEA() {
		
	}
	
	public static byte[] passwordEncode(String passInput, byte[] keyInput) {
		int keyValue = BytesUtils.byteArrayToInt(keyInput);
		byte[] passMask = { 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00 };
		byte[] key = new byte[4];
		key[0] = (byte) keyValue;
		key[1] = (byte) (keyValue + 1);
		key[2] = (byte) (keyValue + 2);
		key[3] = (byte) (keyValue + 3);
		
		BytesUtils.strncpy(passInput.getBytes(), passMask, 0);
		byte[] enc1 = encode(passMask, key);
		byte[] enc2 = encode(Arrays.copyOfRange(passMask, 8, 16), key);
		byte[] result = new byte[16];
		
		BytesUtils.strncpy(enc1, result, 0);
		BytesUtils.strncpy(enc2, result, 8);
		
		return result;
	}
	
	public static byte[] passwordDecode(byte[] passInput, byte[] keyInput) {
		int keyValue = BytesUtils.byteArrayToInt(keyInput);
		byte[] key = new byte[4];
		key[0] = (byte) keyValue;
		key[1] = (byte) (keyValue + 1);
		key[2] = (byte) (keyValue + 2);
		key[3] = (byte) (keyValue + 3);
		
		byte[] dec1 = decode(passInput, key);
		byte[] dec2 = decode(Arrays.copyOfRange(passInput, 8, 16), key);
		byte[] result = new byte[16];
		
		BytesUtils.strncpy(dec1, result, 0);
		BytesUtils.strncpy(dec2, result, 8);
		
		return result;
	}
	
	protected static byte[] encode(byte[] src, byte[] key) {
		int v0 = BytesUtils.byteArrayToInt(Arrays.copyOfRange(src, 0, 4));
		int v1 = BytesUtils.byteArrayToInt(Arrays.copyOfRange(src, 4, 8));
		int sum = 0;
		
		for (int i = 0; i < 32; i++) {
			sum += DELTA;
			v0 += ((v1 << 4) + (key[0] & 0xFF)) ^ (v1 + sum) ^ ((v1 >>> 5) + (key[1] & 0xFF));
			v1 += ((v0 << 4) + (key[2] & 0xFF)) ^ (v0 + sum) ^ ((v0 >>> 5) + (key[3] & 0xFF));
		}
		
		return BytesUtils.intToByteArray(v0, v1);
	}
	
	protected static byte[] decode(byte[] src, byte[] key) {
		int v0 = BytesUtils.byteArrayToInt(Arrays.copyOfRange(src, 0, 4));
		int v1 = BytesUtils.byteArrayToInt(Arrays.copyOfRange(src, 4, 8));
		int sum = 0xC6EF3720;
		
		for (int i = 0; i < 32; i++) {
			v1 -= ((v0 << 4) + (key[2] & 0xFF)) ^ (v0 + sum) ^ ((v0 >>> 5) + (key[3] & 0xFF));
			v0 -= ((v1 << 4) + (key[0] & 0xFF)) ^ (v1 + sum) ^ ((v1 >>> 5) + (key[1] & 0xFF));
			sum -= DELTA;
		}
		
		return BytesUtils.intToByteArray(v0, v1);
	}
}
