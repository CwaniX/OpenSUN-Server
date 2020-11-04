package pl.cwanix.opensun.utils.datatypes;

import java.util.Arrays;

import pl.cwanix.opensun.utils.bytes.ByteRange;
import pl.cwanix.opensun.utils.bytes.BytesUtils;

public class FixedLengthField implements SUNDataType {

    private final byte[] value;

    public FixedLengthField(final int length) {
        this.value = new byte[length];
    }

    public FixedLengthField(final ByteRange range, final byte... bytes) {
        this.value = new byte[range.getLength()];
        setValue(range.getFromArray(bytes));
    }

    public FixedLengthField(final int length, final int begin, final byte... bytes) {
        this.value = new byte[length];
        setValue(begin, bytes);
    }

    public FixedLengthField(final int length, final int begin, final int end, final byte... bytes) {
        this.value = new byte[length];
        setValue(Arrays.copyOfRange(bytes, begin, end));
    }

    public FixedLengthField(final int length, final byte... bytes) {
        this.value = new byte[length];
        setValue(bytes);
    }

    public FixedLengthField(final int length, final String text) {
        this.value = new byte[length];
        setValue(text);
    }

    public FixedLengthField(final int length, final int value) {
        this.value = new byte[length];
        setValue(value);
    }

    public FixedLengthField(final int length, final float value) {
        this.value = new byte[length];
        setValue(value);
    }

    public void setValue(final String text) {
        setValue(text.getBytes());
    }

    public void setValue(final byte... bytes) {
        setValue(0, bytes);
    }

    public void setValue(final int begin, final byte... bytes) {
        for (int i = begin; i < this.value.length; i++) {
            if (i < bytes.length) {
                this.value[i] = bytes[i];
            } else {
                this.value[i] = 0x00;
            }
        }
    }

    public void setValue(final int value) {
        setValue(BytesUtils.intToByteArray(value));
    }

    public void setValue(final float value) {
        setValue(BytesUtils.floatToByteArray(value));
    }

    public int toInt() {
        return BytesUtils.byteArrayToInt(value);
    }

    public short toShort() {
        return BytesUtils.byteArrayToShort(value);
    }

    public String toString() {
        return new String(BytesUtils.cutTail(value));
    }

    public byte toByte() {
        return value[0];
    }

    @Override
    public byte[] toByteArray() {
        return value;
    }
}
