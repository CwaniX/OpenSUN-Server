package pl.cwanix.opensun.utils.encryption;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.commons.io.IOUtils;

public class SimpleModulus {
	
	private enum KeyType {
		MODULUS,
		ENCRYPTION_KEY,
		DECRYPTION_KEY,
		XOR_KEY
	}

	private final static byte[] FILE_HEADER = { 0x12, 0x11 };
	private final static int[] SAVE_LOAD_XOR = { 0x3F08A79B, 0xE25CC287, 0x93D27AB9, 0x20DEA7BF };

	private byte[] modulus;
	private byte[] encryptionKey;
	private byte[] decryptionKey;

	public SimpleModulus(String keyPath) {
		modulus = loadKey(keyPath, KeyType.MODULUS);
		encryptionKey = loadKey(keyPath, KeyType.ENCRYPTION_KEY);
		decryptionKey = loadKey(keyPath, KeyType.DECRYPTION_KEY);
	}

	private byte[] loadKey(String keyPath, KeyType type) {
		try (FileInputStream in = new FileInputStream(keyPath)) {
			byte[] key = IOUtils.toByteArray(in);
			
			if (key[0] != FILE_HEADER[0] || key[1] != FILE_HEADER[1]) {
				throw new Exception("Wrong key data");
			}
			
			return null;
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
}
