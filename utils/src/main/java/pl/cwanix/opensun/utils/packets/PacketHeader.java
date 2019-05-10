package pl.cwanix.opensun.utils.packets;

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
