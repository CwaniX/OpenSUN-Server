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

    private static final int X_VALUE_POSITION = 0;
    private static final int Y_VALUE_POSITION = 4;
    private static final int Z_VALUE_POSITION = 8;
    private static final int DATA_ARRAY_SIZE = 12;


    private float x;
    private float y;
    private float z;

    public Vector() {
        x = 0;
        y = 0;
        z = 0;
    }

    public Vector(final byte[] value) {
        ByteBuffer buffer = ByteBuffer.wrap(value).order(ByteOrder.LITTLE_ENDIAN);

        x = buffer.getFloat(X_VALUE_POSITION);
        y = buffer.getFloat(Y_VALUE_POSITION);
        z = buffer.getFloat(Z_VALUE_POSITION);
    }

    @Override
    public byte[] toByteArray() {
        return ByteBuffer.allocate(DATA_ARRAY_SIZE).order(ByteOrder.LITTLE_ENDIAN).putFloat(x).putFloat(y).putFloat(z).array();
    }
}
