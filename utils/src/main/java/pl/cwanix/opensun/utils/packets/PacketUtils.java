package pl.cwanix.opensun.utils.packets;

import java.util.Arrays;

public class PacketUtils {
	
	private PacketUtils() {
		
	}

	public static String byteArrayToHexString(byte[] msg) {
		StringBuilder sb = new StringBuilder();
		
		for (byte foo : msg){
			sb.append(String.format("%02x ", foo));
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
}
