package pl.cwanix.opensun.utils.encryption;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import pl.cwanix.opensun.utils.bytes.BytesUtils;
import pl.cwanix.opensun.utils.encryption.SimpleModulus.Mode;

public class SimpleModulusTest {
	
	private SimpleModulus simpleModulusEnc = new SimpleModulus("./src/test/resources/encryption/Enc1.dat", Mode.ENCRYPT);
	private SimpleModulus simpleModulusDec = new SimpleModulus("./src/test/resources/encryption/Dec1.dat", Mode.DECRYPT);
	
	@Test
	public void shouldEncrypt() {
		byte[] result = simpleModulusEnc.encrypt("Test123456".getBytes());
		
		System.out.println(BytesUtils.byteArrayToHexString(result));
		
		byte[] dec = simpleModulusDec.decrypt(result);
		
		System.out.println(BytesUtils.byteArrayToHexString(dec));
	}
	
	@Test
	public void shouldEncryptBlock() {
		byte[] source = { 0x10, 0x20, 0x30, 0x40, 0x50, 0x60, 0x70, (byte) 0x80 };
		byte[] dest = new byte[11];
		int result = simpleModulusEnc.encryptBlock(dest, source, 8);
		
		byte[] decd = new byte[8];
		int dec = simpleModulusDec.decryptBlock(decd, dest);
		
		System.out.println(BytesUtils.byteArrayToHexString(decd));
	}

	@DisplayName("Shift")
	@ParameterizedTest(name = "Shifting data: {0}, by: {1} should be: {2}")
	@MethodSource("shiftDataSource")
	public void shouldShiftData(byte[] input, int shiftLength, byte[] expected) {
		byte[] result = simpleModulusEnc.shift(input, input.length, shiftLength);
		
		assertArrayEquals(expected, result);
	}
	
	@DisplayName("Add bits")
	@ParameterizedTest(name = "Add bits: {5}")
	@MethodSource("addBitsDataSource")
	public void shouldAddBits(byte[] output, int destBitPos, byte[] input, int sourceBitPos, int bitLength, byte[] expected) {
		simpleModulusEnc.addBits(output, destBitPos, input, sourceBitPos, bitLength);
		
		assertArrayEquals(expected, output);
	}
	
	@SuppressWarnings("unused")
	private static Stream<Arguments> addBitsDataSource() {
		return Stream.of(
					Arguments.of(new byte[] { 0x10, 0x20, 0x30, 0x40, 0x50, 0x60, 0x70, (byte) 0x80 }, 0, new byte[] { 0x10, 0x10, 0x10, 0x10, 0x10, 0x10, 0x10, 0x10 }, 0, 16, new byte[] { 0x10, 0x30, 0x30, 0x40, 0x50, 0x60, 0x70, (byte) 0x80 }),
					Arguments.of(new byte[] { 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00 }, 0, new byte[] { 0x10, 0x10, 0x10, 0x10, 0x10, 0x10, 0x10, 0x10 }, 0, 16, new byte[] { 0x10, 0x10, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00 }),
					Arguments.of(new byte[] { 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00 }, 0, new byte[] { 0x10, 0x10, 0x10, 0x10, 0x10, 0x10, 0x10, 0x10 }, 0, 32, new byte[] { 0x10, 0x10, 0x10, 0x10, 0x00, 0x00, 0x00, 0x00 }),
					Arguments.of(new byte[] { 0x10, 0x20, 0x30, 0x40, 0x50, 0x60, 0x70, (byte) 0x80 }, 0, new byte[] { 0x10, 0x10, 0x10, 0x10, 0x10, 0x10, 0x10, 0x10 }, 5, 32, new byte[] { 0x12, 0x22, 0x32, 0x42, 0x50, 0x60, 0x70, (byte) 0x80 }),
					Arguments.of(new byte[] { 0x10, 0x20, 0x30, 0x40, 0x50, 0x60, 0x70, (byte) 0x80 }, 2, new byte[] { 0x10, 0x10, 0x10, 0x10, 0x10, 0x10, 0x10, 0x10 }, 5, 32, new byte[] { 0x10, (byte) 0xa0, (byte) 0xb0, (byte) 0xc0, (byte) 0xd0, 0x60, 0x70, (byte) 0x80 })
				);
	}
	
	@SuppressWarnings("unused")
	private static Stream<Arguments> shiftDataSource() {
		return Stream.of(
					Arguments.of(new byte[] { 0x10, 0x10, 0x10, 0x10 }, -16, new byte[] { 0x00, 0x00, 0x00, 0x00 }),
					Arguments.of(new byte[] { 0x10, 0x10, 0x10, 0x10 }, -2, new byte[] { 0x40, 0x40, 0x40, 0x40 }),
					Arguments.of(new byte[] { 0x10, 0x10, 0x10, 0x10 }, -1, new byte[] { 0x20, 0x20, 0x20, 0x20 }),
					Arguments.of(new byte[] { 0x10, 0x10, 0x10, 0x10 }, 0, new byte[] { 0x10, 0x10, 0x10, 0x10 }),
					Arguments.of(new byte[] { 0x10, 0x10, 0x10, 0x10 }, 1, new byte[] { 0x08, 0x08, 0x08, 0x08 }),
					Arguments.of(new byte[] { 0x10, 0x10, 0x10, 0x10 }, 2, new byte[] { 0x04, 0x04, 0x04, 0x04 }),
					Arguments.of(new byte[] { 0x10, 0x10, 0x10, 0x10 }, 16, new byte[] { 0x00, 0x00, 0x00, 0x00 }),
					Arguments.of(new byte[] { 0x1a, 0x1b, 0x1c, 0x1d }, -1, new byte[] { 0x34, 0x36, 0x38, 0x3a }),
					Arguments.of(new byte[] { 0x1a, 0x1b, 0x1c, 0x1d }, 1, new byte[] { 0x0d, 0x0d, (byte) 0x8e, 0x0e })
				);
	}
}
