package pl.cwanix.opensun.utils.datatypes;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@EqualsAndHashCode
@RequiredArgsConstructor
public class PacketHeader {

	private final byte idA;
	private final byte idB;
	
	public byte[] getValue() {
		return new byte[] { idA, idB };
	}
}
