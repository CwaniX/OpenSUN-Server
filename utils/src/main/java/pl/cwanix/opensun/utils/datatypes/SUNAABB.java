package pl.cwanix.opensun.utils.datatypes;

import lombok.Getter;
import lombok.Setter;

import java.util.Arrays;

@Getter
@Setter
@SuppressWarnings("checkstyle:MagicNumber")
public class SUNAABB implements SUNDataType {

    private Vector min;
    private Vector max;

    public SUNAABB(final byte[] value) {
        this.min = new Vector(Arrays.copyOfRange(value, 0, 12));
        this.max = new Vector(Arrays.copyOfRange(value, 12, 24));
    }

    @Override
    public byte[] toByteArray() throws Exception {
        return new byte[0];
    }
}
