package pl.cwanix.opensun.utils.bytes;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.io.ByteArrayOutputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class BytesUtils {

    private static final int SHORT_LENGTH = 2;
    private static final int INT_LENGTH = 4;
    private static final int FLOAT_LENGTH = 4;
    private static final int LONG_LENGTH = 8;

    public static void strncpy(final byte[] input, final byte[] output, final int start) {
        for (int i = 0; i < input.length; i++) {
            output[i + start] = input[i];
        }
    }

    public static long byteArrayToLong(final byte[] input) {
        return ByteBuffer.wrap(input).order(ByteOrder.LITTLE_ENDIAN).getLong();
    }

    public static int byteArrayToInt(final byte[] input) {
        return ByteBuffer.wrap(input).order(ByteOrder.LITTLE_ENDIAN).getInt();
    }

    public static short byteArrayToShort(final byte[] input) {
        return ByteBuffer.wrap(input).order(ByteOrder.LITTLE_ENDIAN).getShort();
    }

    public static byte[] longToByteArray(final long... input) {
        ByteBuffer buffer = ByteBuffer.allocate(input.length * LONG_LENGTH).order(ByteOrder.LITTLE_ENDIAN);

        for (long i : input) {
            buffer.putLong(i);
        }

        return buffer.array();
    }

    public static byte[] floatToByteArray(final float... input) {
        ByteBuffer buffer = ByteBuffer.allocate(input.length * FLOAT_LENGTH).order(ByteOrder.LITTLE_ENDIAN);

        for (float i : input) {
            buffer.putFloat(i);
        }

        return buffer.array();
    }

    public static byte[] intToByteArray(final int... input) {
        ByteBuffer buffer = ByteBuffer.allocate(input.length * INT_LENGTH).order(ByteOrder.LITTLE_ENDIAN);

        for (int i : input) {
            buffer.putInt(i);
        }

        return buffer.array();
    }

    public static byte[] shortToByteArray(final short... input) {
        ByteBuffer buffer = ByteBuffer.allocate(input.length * SHORT_LENGTH).order(ByteOrder.LITTLE_ENDIAN);

        for (short i : input) {
            buffer.putShort(i);
        }

        return buffer.array();
    }

    public static String byteArrayToHexString(final byte[] input) {
        StringBuilder sb = new StringBuilder();

        for (byte b : input) {
            sb.append(String.format("%02x ", b));
        }

        return sb.toString();
    }

    public static byte[] mergeArrays(final byte[]... arrays) {
        int finalLength = 0;
        for (byte[] array: arrays) {
            finalLength += array.length;
        }

        byte[] dest = null;
        int destPos = 0;

        for (byte[] array : arrays) {
            if (dest == null) {
                dest = Arrays.copyOf(array, finalLength);
                destPos = array.length;
            } else {
                System.arraycopy(array, 0, dest, destPos, array.length);
                destPos += array.length;
            }
        }

        return dest;
    }

    public static byte[] cutTail(final byte[] input) {
        ByteArrayOutputStream out = new ByteArrayOutputStream();

        int counter = 0;

        while (counter < input.length) {
            if (input[counter] != 0x00) {
                out.write(input[counter]);
                counter++;
            } else {
                break;
            }
        }

        return out.toByteArray();
    }
}
