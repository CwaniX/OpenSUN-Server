package pl.cwanix.opensun.utils.encryption;

import java.io.FileInputStream;

import org.apache.commons.io.IOUtils;
import org.slf4j.Marker;
import org.slf4j.MarkerFactory;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class SimpleModulus {

	private static final Marker MARKER = MarkerFactory.getMarker("SIMPLE MODULUS");

	private final static int ENCRYPTION_KEY_SIZE = 4;
	private final static int ENCRYPTION_BLOCK_SIZE = 8;
	private final static byte[] FILE_HEADER = { 0x12, 0x11 };
	private final static int[] SAVE_LOAD_XOR = { 0x3F08A79B, 0xE25CC287, 0x93D27AB9, 0x20DEA7BF };

	private int[] modulus;
	private int[] encryptionKey;
	private int[] decryptionKey;
	
	public SimpleModulus() {
		
	}

	public SimpleModulus(String keyPath) {
		try {
			modulus = loadKey(keyPath, 1);
			encryptionKey = loadKey(keyPath, 2);
			decryptionKey = loadKey(keyPath, 3);
		} catch (Exception e) {
			log.error(MARKER, "Error when loading key file: {}", keyPath);
		}
	}

	protected byte[] shift(byte[] buffer, int size, int shiftLength) {

		if (shiftLength == 0) {
			return buffer;
		}

		if (shiftLength > 0) {
			for (int i = size - 1; i > 0; i--) {
				buffer[i] = (byte) ((buffer[i-1] << ((ENCRYPTION_BLOCK_SIZE - shiftLength))) | buffer[i] >>> shiftLength);
			}
			
			buffer[0] >>>= shiftLength;
		} else {
			shiftLength =- shiftLength;
			
			for (int i = 0; i < size - 1; i++) {
				buffer[i] = (byte) ((buffer[i + 1] >>> ((ENCRYPTION_BLOCK_SIZE - shiftLength))) | buffer[i] << shiftLength);
			}
			

			buffer[size - 1] <<= shiftLength;
		}
		
		return buffer;
	}

	private int[] loadKey(String keyPath, int keyIndex) throws Exception {
		try (FileInputStream in = new FileInputStream(keyPath)) {
			byte[] key = IOUtils.toByteArray(in);
			int[] result = new int[ENCRYPTION_KEY_SIZE];

			if (!isValidKeyHeader(key)) {
				throw new Exception("Wrong key data");
			}

			for (int i = 0; i < ENCRYPTION_KEY_SIZE; i++) {
				result[i] = SAVE_LOAD_XOR[i] ^ key[i + 5 + (keyIndex - 1) * 4];
			}

			return result;
		}
	}

	private boolean isValidKeyHeader(byte[] key) {
		return key[0] == FILE_HEADER[0] && key[1] == FILE_HEADER[1];
	}
}
