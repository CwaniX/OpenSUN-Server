package pl.cwanix.opensun.utils.encryption;

import java.io.FileInputStream;
import java.util.Arrays;

import org.apache.commons.io.IOUtils;
import org.slf4j.Marker;
import org.slf4j.MarkerFactory;

import lombok.extern.slf4j.Slf4j;
import pl.cwanix.opensun.utils.bytes.BytesUtils;

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
	private int[] xorKey;
	
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
	
	protected byte[] encryptBlock(byte[] lpDest, byte[] lpSource, int iSize) {
		int[] dwEncBuffer =  new int[4];
		byte[] dwEncValue = new byte[2];
		
		for (int i=0; i<4; i++)
		{
			dwEncBuffer[i] = ((xorKey[i] ^ lpSource[i] ^ dwEncValue) * encryptionKey[i]) % modulus[i];
			dwEncValue = dwEncBuffer[i] & 0xFFFF;
		}
		
		for (int i=0; i<3; i++)
		{
			dwEncBuffer[i] = dwEncBuffer[i] ^ xorKey[i] ^ ( dwEncBuffer[i+1] & 0xFFFF );
		}
		
		int iBitPos = 0;

		for (int i=0; i<ENCRYPTION_KEY_SIZE; i++)
		{
			iBitPos = addBits(lpDest, iBitPos, dwEncBuffer[i], 0, 16);
			iBitPos = addBits(lpDest, iBitPos, dwEncBuffer[i], 22, 2);
		}

		byte btCheckSum = (byte) 0xF8;
		
		for (int i=0;i<ENCRYPTION_BLOCK_SIZE;i++)
			btCheckSum ^= lpSource[i];

		dwEncValue[1] = btCheckSum ; 
		dwEncValue[0] = (byte) (btCheckSum ^ iSize ^ 0x3D); 

		return addBits(lpDest, iBitPos, dwEncValue, 0, 16);
	}
	
	protected byte[] addBits(byte[] lpDest, int iDestBitPos, byte[] lpSource, int iBitSourcePos, int iBitLen) {
		int iSourceBufferBitLen = iBitLen + iBitSourcePos;
		int iTempBufferLen = getByteOfBit(iSourceBufferBitLen - 1);
		
		iTempBufferLen += 1 - getByteOfBit(iBitSourcePos);
		
		byte[] pTempBuffer = new byte[iTempBufferLen + 1];
		
		for (int i = 0; i < iTempBufferLen; i++) {
			pTempBuffer[i] = lpSource[i + getByteOfBit(iBitSourcePos)];
		}
		
		if ( (iSourceBufferBitLen%8 ) != 0 )
		{
			pTempBuffer[iTempBufferLen - 1] &= 255 << (8 - (iSourceBufferBitLen%8));
		}
		
		int iShiftLeft = (iBitSourcePos%8);
		int iShiftRight = (iDestBitPos%8);
		
		pTempBuffer = shift(pTempBuffer, iTempBufferLen, -iShiftLeft);
		pTempBuffer = shift(pTempBuffer, iTempBufferLen+1, iShiftRight);
		
		int iNewTempBufferLen = (( iShiftRight <= iShiftLeft )?0:1) + iTempBufferLen;
		byte[] tempDist = Arrays.copyOfRange(lpDest, getByteOfBit(iDestBitPos), lpDest.length);
		
		for ( int i=0;i<iNewTempBufferLen;i++)
		{
			tempDist[i] |= pTempBuffer[i];
		}
		
		return tempDist;
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
	
	private int getByteOfBit(int bit) {
		return bit >>> 3;
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
