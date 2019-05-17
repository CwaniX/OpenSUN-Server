package pl.cwanix.opensun.utils.encryption;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import pl.cwanix.opensun.utils.bytes.BytesUtils;
import pl.cwanix.opensun.utils.encryption.SimpleModulus.Mode;

public class SimpleModulusTest {

	private static SimpleModulus simpleModulusEnc;
	private static SimpleModulus simpleModulusDec;

	@BeforeAll
	public static void setUp() {
		simpleModulusEnc = new SimpleModulus("./src/test/resources/encryption/Enc1.dat", Mode.ENCRYPT);
		simpleModulusDec = new SimpleModulus("./src/test/resources/encryption/Dec1.dat", Mode.DECRYPT);
	}

	@Test
	public void shouldEncrypt() {
		/*
		 * System.out.println(BytesUtils.byteArrayToHexString("Test123456".getBytes()));
		 * 
		 * byte[] result = simpleModulusEnc.encrypt("Test123456".getBytes());
		 * 
		 * System.out.println(BytesUtils.byteArrayToHexString(result));
		 * 
		 * byte[] dec = simpleModulusDec.decrypt(result);
		 * 
		 * System.out.println(BytesUtils.byteArrayToHexString(dec));
		 */
	}

	@DisplayName("Encrypt block")
	@ParameterizedTest(name = "Encrypting block of data: {0}, of size: {1}, result should be: {2}")
	@CsvFileSource(resources = "/encryption/SimpleModulusEncryptBlock.csv", delimiter = ';')
	public void shouldEncryptBlock(String sourceString, int size, String expectedString) {
		byte[] source = BytesUtils.hexStringToByteArray(sourceString);
		byte[] expected = BytesUtils.hexStringToByteArray(expectedString);
		byte[] dest = new byte[11];
		
		simpleModulusEnc.encryptBlock(dest, source, size);
		
		System.out.println(BytesUtils.byteArrayToHexString(dest));

		assertArrayEquals(expected, dest);
	}

	@DisplayName("Shift")
	@ParameterizedTest(name = "Shifting data: {0}, by: {1} should be: {2}")
	@CsvFileSource(resources = "/encryption/SimpleModulusShift.csv", delimiter = ';')
	public void shouldShiftData(String inputString, int shiftLength, String expectedString) {
		byte[] input = BytesUtils.hexStringToByteArray(inputString);
		byte[] expected = BytesUtils.hexStringToByteArray(expectedString);
		
		simpleModulusEnc.shift(input, input.length, shiftLength);

		assertArrayEquals(expected, input);
	}

	@DisplayName("Add bits")
	@ParameterizedTest(name = "Add bits: {5}")
	@CsvFileSource(resources = "/encryption/SimpleModulusAddBits.csv", delimiter = ';')
	public void shouldAddBits(String outputString, int destBitPos, String inputString, int sourceBitPos, int bitLength, String expectedString) {
		byte[] output = BytesUtils.hexStringToByteArray(outputString);
		byte[] input = BytesUtils.hexStringToByteArray(inputString);
		byte[] expected = BytesUtils.hexStringToByteArray(expectedString);
		
		simpleModulusEnc.addBits(output, destBitPos, input, sourceBitPos, bitLength);

		assertArrayEquals(expected, output);
	}
}
