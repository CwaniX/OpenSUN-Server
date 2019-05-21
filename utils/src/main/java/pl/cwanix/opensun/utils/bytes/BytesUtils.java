package pl.cwanix.opensun.utils.bytes;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;

import org.apache.commons.lang3.StringUtils;

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
	
	public static byte[] intToByteArray(int... input) {
		ByteBuffer buffer = ByteBuffer.allocate(input.length * 4).order(ByteOrder.LITTLE_ENDIAN);
		
		for (int i : input) {
			buffer.putInt(i);
		}
		
		return buffer.array();
	}
	
	/**
	 * Converts byte array to string.
	 * 
	 * @param input
	 * @return
	 */
	public static String byteArrayToHexString(byte[] input) {
		StringBuilder sb = new StringBuilder();
		
		for (byte b : input) {
			sb.append(String.format("%02x ", b));
		}
		
		return sb.toString();
	}
	
	/**
	 * Converts string containig hexadecimal data to byte array.
	 * 
	 * @param input
	 * @return
	 */
	public static byte[] hexStringToByteArray(String input) {
		input = StringUtils.replace(input, "0x", "");
		input = StringUtils.replace(input, " ", "");
		
		int len = input.length();
		byte[] data = new byte[len / 2];
		for (int i = 0; i < len; i += 2) {
			data[i / 2] = (byte) ((Character.digit(input.charAt(i), 16) << 4) + Character.digit(input.charAt(i + 1), 16));
		}
		
		return data;
	}
	
	/**
	 * Merges several arrays into one.
	 * 
	 * @param arrays
	 * @return
	 */
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
}
