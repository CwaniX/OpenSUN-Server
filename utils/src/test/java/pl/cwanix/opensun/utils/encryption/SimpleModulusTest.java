package pl.cwanix.opensun.utils.encryption;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class SimpleModulusTest {
	
	private SimpleModulus simpleModulus = new SimpleModulus();

	@DisplayName("Shift")
	@ParameterizedTest(name = "Shifting data: {0}, by: {1} should be: {2}")
	@MethodSource("shiftDataSource")
	public void shouldShiftData(byte[] input, int shiftLength, byte[] expected) {
		byte[] result = simpleModulus.shift(input, input.length, shiftLength);
		
		assertArrayEquals(expected, result);
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
