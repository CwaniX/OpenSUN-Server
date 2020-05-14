package pl.cwanix.opensun.utils.datatypes;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class SUNId implements SUNDataType {

	private final int id;

	@Override
	public byte[] toByteArray() throws Exception {
		return new byte[0];
	}
}
