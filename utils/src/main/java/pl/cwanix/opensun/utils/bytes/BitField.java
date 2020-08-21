package pl.cwanix.opensun.utils.bytes;

public class BitField {

    private final long mask;
    private final long shift;

    public BitField(final long mask) {
        this.mask = mask;
        this.shift = mask == 0 ? 0 : Long.numberOfTrailingZeros(mask);
    }

    public long getValue(final long data) {
        return (data & mask) >> shift;
    }

    public long setValue(final long data, final long value) {
        return (data & ~mask) | ((value << shift) & mask);
    }
}
