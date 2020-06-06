package pl.cwanix.opensun.utils.datatypes;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class SUNColor implements SUNDataType {

    private byte r;
    private byte g;
    private byte b;

    public SUNColor() {
        this.r = 0;
        this.g = 0;
        this.b = 0;
    }

    public SUNColor(byte[] value) {
        this.r = value[0];
        this.g = value[1];
        this.b = value[2];
    }

    @Override
    public byte[] toByteArray() throws Exception {
        return new byte[0];
    }
}
