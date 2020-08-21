package pl.cwanix.opensun.utils.datatypes;

import lombok.Getter;
import lombok.Setter;
import pl.cwanix.opensun.utils.bytes.BytesUtils;

import java.util.Arrays;

@Getter
@Setter
public class SUNAABB implements SUNDataType {

    private Vector min;
    private Vector max;

    public SUNAABB(byte[] value) {
        this.min = new Vector(Arrays.copyOfRange(value, 0, 12));
        this.max = new Vector(Arrays.copyOfRange(value, 12, 24));
    }

    @Override
    public byte[] toByteArray() throws Exception {
        return new byte[0];
    }
}
