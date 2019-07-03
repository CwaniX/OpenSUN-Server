package pl.cwanix.opensun.utils.datatypes;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Vector implements SUNDataType {

	private float x;
	private float y;
	private float z;
	
	public Vector(byte[] value) {
		ByteBuffer buffer = ByteBuffer.wrap(value).order(ByteOrder.LITTLE_ENDIAN);
		
		x = buffer.getFloat(0);
		y = buffer.getFloat(4);
		z = buffer.getFloat(8);
	}
	
	@Override
	public byte[] toByteArray() {
		return ByteBuffer.allocate(12).putFloat(x).putFloat(y).putFloat(z).array();
	}
}
