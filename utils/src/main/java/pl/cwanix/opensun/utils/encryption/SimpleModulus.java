package pl.cwanix.opensun.utils.encryption;

import java.io.FileInputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;

import org.apache.commons.io.IOUtils;
import org.slf4j.Marker;
import org.slf4j.MarkerFactory;

import lombok.extern.slf4j.Slf4j;
import pl.cwanix.opensun.utils.bytes.BytesUtils;

@Slf4j
public class SimpleModulus {

	public enum Mode {
		ENCRYPT, DECRYPT
	}

	private static final Marker MARKER = MarkerFactory.getMarker("SIMPLE MODULUS");

	private static final int ENCRYPTION_KEY_SIZE = 4;
	private static final int ENCRYPTION_BLOCK_SIZE = 8;
	private static final byte[] FILE_HEADER = { 0x12, 0x11 };
	private static final int[] SAVE_LOAD_XOR = { 0x3F08A79B, 0xE25CC287, 0x93D27AB9, 0x20DEA7BF };

	private int[] modulus;
	private int[] encryptionKey;
	private int[] decryptionKey;
	private int[] xorKey;

	public SimpleModulus(String keyPath, Mode mode) {
		try {
			modulus = loadKey(keyPath, 1);
			xorKey = loadKey(keyPath, 3);

			if (mode.equals(Mode.ENCRYPT)) {
				encryptionKey = loadKey(keyPath, 2);
			} else {
				decryptionKey = loadKey(keyPath, 2);
			}
		} catch (Exception e) {
			log.error(MARKER, "Error when loading key file: {}", keyPath, e);
		}
	}

	public byte[] encrypt(byte[] source) {
		int iDec = ((source.length + 7) / 8);
		iDec = (iDec + iDec * 4) * 2 + iDec;

		byte[] dest = new byte[iDec];
		int iOriSize = source.length;
		int iDest = 0;
		int iTempSize2 = 0;

		byte[] tempDest = new byte[11];
		byte[] tempSrc = new byte[8];

		for (int i = 0; i < source.length; i += 8, iOriSize -= 8, iDest += 11) {
			iTempSize2 = iOriSize;

			if (iOriSize >= 8) {
				iTempSize2 = 8;
			}

			for (int x = 0; x < iTempSize2; x++) {
				tempSrc[x] = source[x + i];
			}

			encryptBlock(tempDest, tempSrc, iTempSize2);

			for (int x = 0; x < 11; x++) {
				dest[x + iDest] = tempDest[x];
			}
		}

		return dest;
	}

	protected int encryptBlock(byte[] dest, byte[] source, int size) {
		int[] encBuffer = new int[4];
		int encValue = 0;
		ByteBuffer encSource = ByteBuffer.wrap(source).order(ByteOrder.LITTLE_ENDIAN);

		for (int i = 0; i < 4; i++) {
			encBuffer[i] = ((xorKey[i] ^ encSource.getShort(i * 2) ^ encValue) * encryptionKey[i]) % modulus[i];
			encValue = encBuffer[i] & 0xFFFF;
		}

		for (int i = 0; i < 3; i++) {
			encBuffer[i] = encBuffer[i] ^ xorKey[i] ^ (encBuffer[i + 1] & 0xFFFF);
		}

		int iBitPos = 0;

		for (int i = 0; i < ENCRYPTION_KEY_SIZE; i++) {
			byte[] encBufferBits = BytesUtils.intToByteArray(encBuffer[i]);
			iBitPos = addBits(dest, iBitPos, encBufferBits, 0, 16);
			iBitPos = addBits(dest, iBitPos, encBufferBits, 22, 2);
		}

		byte btCheckSum = (byte) 0xF8;

		for (int i = 0; i < ENCRYPTION_BLOCK_SIZE; i++) {
			btCheckSum ^= source[i];
		}

		byte[] checkSum = new byte[2];

		checkSum[1] = btCheckSum;
		checkSum[0] = (byte) (btCheckSum ^ size ^ 0x3D);

		return addBits(dest, iBitPos, checkSum, 0, 16);
	}
	
	public byte[] decrypt(byte[] src) {
        int iEnc = src.length * 8 / 11;
        byte[] dest = new byte[iEnc];

        int decLen = 0;
        int destPos = 0;
        int iResult = 0;
        byte[] tempDest = new byte[8];
        byte[] tempSrc = new byte[11];

        while (decLen < src.length)
        {
            //Array.Copy(src, decLen, tempSrc, 0, 11);
            
            for (int i = 0; i < 11; i++) {
            	src[decLen + i] = tempSrc[i];
            }

            int tempResult = decryptBlock(tempDest, tempSrc);

            //Array.Copy(tempDest, 0, dest, destPos, 8);
            
            for (int i = 0; i < 8; i++) {
            	tempDest[i] = dest[destPos + i];
            }

            if (iResult < 0)
            	System.out.println("Error decoding buffer");
                //throw new Exception("Error decoding buffer");

            iResult += tempResult;
            decLen += 11;
            destPos += 8;
        }

        return dest;
	}

	protected int decryptBlock(byte[] dest, byte[] src) {
		byte[] tempDest = new byte[4];
		int[] decBuffer = new int[4];
		int bitPos = 0;

		for (int i = 0; i < 4; i++) {
			addBits(tempDest, 0, src, bitPos, 16);
			bitPos += 16;
			addBits(tempDest, 22, src, bitPos, 2);
			bitPos += 2;
			decBuffer[i] = BytesUtils.byteArrayToInt(tempDest);
			Arrays.fill(tempDest, (byte) 0x00);
		}

		for (int i = 2; i >= 0; i--) {
			decBuffer[i] = decBuffer[i] ^ xorKey[i] ^ (decBuffer[i + 1] & 0xFFFF);
		}

		short Temp = 0;
		int Temp1 = 0;

		for (int i = 0; i < 4; i++) {
			Temp1 = ((decryptionKey[i] * decBuffer[i]) % modulus[i]) ^ xorKey[i] ^ Temp;
			Temp = (short) (decBuffer[i] & 0xFFFF);
			
			byte[] temp1Bytes = BytesUtils.intToByteArray(Temp1);
			for (int x = 0; x < 2; x++) {
				dest[x + i * 2] = temp1Bytes[x];
			}
			
			// Array.Copy(BitConverter.GetBytes(Temp1), 0, dest, i * 2, 2);
		}

		Arrays.fill(tempDest, (byte) 0x00);
		addBits(tempDest, 0, src, bitPos, 16);

		tempDest[0] = (byte) (tempDest[1] ^ tempDest[0] ^ 0x3D);

		byte CheckSum = (byte) 0xF8;
		for (int i = 0; i < 8; i++)
			CheckSum ^= dest[i];

		if (CheckSum != tempDest[1])
			return -1;

		return tempDest[0];
	}

	protected int addBits(byte[] dest, int destPosition, byte[] source, int sourcePosition, int sourceLength) {
		int iSourceBufferBitLen = sourceLength + sourcePosition;
		int iTempBufferLen = getByteOfBit(iSourceBufferBitLen - 1);
		iTempBufferLen += 1 - getByteOfBit(sourcePosition);

		byte[] pTempBuffer = new byte[iTempBufferLen + 1];

		for (int i = 0; i < iTempBufferLen; i++) {
			pTempBuffer[i] = source[i + getByteOfBit(sourcePosition)];
		}

		if ((iSourceBufferBitLen % 8) != 0) {
			pTempBuffer[iTempBufferLen - 1] &= 255 << (8 - (iSourceBufferBitLen % 8));
		}

		int iShiftLeft = (sourcePosition % 8);
		int iShiftRight = (destPosition % 8);

		pTempBuffer = shift(pTempBuffer, iTempBufferLen, -iShiftLeft);
		pTempBuffer = shift(pTempBuffer, iTempBufferLen + 1, iShiftRight);

		int iNewTempBufferLen = ((iShiftRight <= iShiftLeft) ? 0 : 1) + iTempBufferLen;

		int currentPosition = getByteOfBit(destPosition);
		for (int i = 0; i < iNewTempBufferLen; i++) {
			dest[currentPosition + i] |= pTempBuffer[i];
		}

		return destPosition + sourceLength;
	}

	protected byte[] shift(byte[] buffer, int size, int shiftLength) {
		if (shiftLength == 0) {
			return buffer;
		}

		if (shiftLength > 0) {
			for (int i = size - 1; i > 0; i--) {
				buffer[i] = (byte) ((buffer[i - 1] << (ENCRYPTION_BLOCK_SIZE - shiftLength))
						| buffer[i] >>> shiftLength);
			}

			buffer[0] >>>= shiftLength;
		} else {
			shiftLength = -shiftLength;

			for (int i = 0; i < size - 1; i++) {
				buffer[i] = (byte) ((buffer[i + 1] >>> (ENCRYPTION_BLOCK_SIZE - shiftLength))
						| buffer[i] << shiftLength);
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
