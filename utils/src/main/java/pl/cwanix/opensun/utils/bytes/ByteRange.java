package pl.cwanix.opensun.utils.bytes;

import lombok.Value;

import java.util.Arrays;

@Value(staticConstructor = "of")
public class ByteRange {

    private int start;
    private int end;

    public static ByteRange of(final int start) {
        return new ByteRange(start, start + 1);
    }

    public byte[] getFromArray(final byte... value) {
        return Arrays.copyOfRange(value, start, end);
    }

    public int getLength() {
        return end - start;
    }
}
