package pl.cwanix.opensun.utils.bytes;

import java.io.ByteArrayOutputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;

public class BytesUtils {
	
	private BytesUtils() {
		
	}

	public static void strncpy(byte[] input, byte[] output, int start) {
		for (int i = 0; i < input.length; i++) {
			output[i + start] = input[i];
		}
	}
	
	public static int byteArrayToInt(byte[] input) {
		return ByteBuffer.wrap(input).order(ByteOrder.LITTLE_ENDIAN).getInt();
	}
	
	public static short byteArrayToShort(byte[] input) {
		return ByteBuffer.wrap(input).order(ByteOrder.LITTLE_ENDIAN).getShort();
	}
	
	public static byte[] intToByteArray(int... input) {
		ByteBuffer buffer = ByteBuffer.allocate(input.length * 4).order(ByteOrder.LITTLE_ENDIAN);
		
		for (int i : input) {
			buffer.putInt(i);
		}
		
		return buffer.array();
	}
	
	public static String byteArrayToHexString(byte[] input) {
		StringBuilder sb = new StringBuilder();
		
		for (byte b : input) {
			sb.append(String.format("%02x ", b));
		}
		
		return sb.toString();
	}
	
	public static byte[] mergeArrays(byte[]... arrays) {
		int finalLength = 0;
		for (byte[] array: arrays) {
			finalLength += array.length;
		}
		
		byte[] dest = null;
		int destPos = 0;
		
		for (byte[] array : arrays) {
			if (dest == null) {
				dest = Arrays.copyOf(array, finalLength);
				destPos = array.length;
			} else {
				System.arraycopy(array, 0, dest, destPos, array.length);
				destPos += array.length;
			}
		}
		
		return dest;
	}
	
	public static byte[] cutTail(byte[] input) {
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		
		int counter = 0;
		
		while (counter < input.length) {
			if (input[counter] != 0x00) {
				out.write(input[counter]);
				counter++;
			} else {
				break;
			}
		}
		
		return out.toByteArray();
	}
}
