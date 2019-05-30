package pl.cwanix.opensun.utils.encryption;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class TEATest {

	@DisplayName("TEA Encoding")
	@ParameterizedTest(name = "Encoding password: {0}")
	@MethodSource("encDecDataSource")
	public void shouldEncryptData(String input, byte[] expected, byte[] key) {
		byte[] result = TEA.encode(input.getBytes(), key);

		assertArrayEquals(expected, result);
	}

	@DisplayName("TEA Decoding")
	@ParameterizedTest(name = "Decoding password: {0}")
	@MethodSource("encDecDataSource")
	public void shouldDecryptData(String expected, byte[] input, byte[] key) {
		byte[] result = TEA.decode(input, key);

		assertArrayEquals(expected.getBytes(), result);
	}

	@SuppressWarnings("unused")
	private static Stream<Arguments> encDecDataSource() {
		return Stream.of(
					Arguments.of("aaaaaaaa", new byte[] { (byte) 0xfb, 0x4e, 0x4a, (byte) 0xef, 0x1e, 0x4f, 0x5b, 0x6a }, new byte[] { 0x00, 0x01, 0x02, 0x03 }),
					Arguments.of("ssssssss", new byte[] { 0x66, (byte) 0xe6, 0x32, 0x12, 0x0a, (byte) 0xc9, (byte) 0xe5, (byte) 0xa8 }, new byte[] { 0x00, 0x01, 0x02, 0x03 })
				);
	}
}
