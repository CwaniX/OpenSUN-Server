package pl.cwanix.opensun.authserver.packet.c2s.auth;

import lombok.Getter;
import pl.cwanix.opensun.commonserver.packets.Packet;
import pl.cwanix.opensun.commonserver.packets.PacketCategory;
import pl.cwanix.opensun.commonserver.packets.annotations.IncomingPacket;
import pl.cwanix.opensun.commonserver.packets.annotations.PacketOPCode;
import pl.cwanix.opensun.utils.bytes.ByteRange;
import pl.cwanix.opensun.utils.datatypes.FixedLengthField;

@Getter
@IncomingPacket(category = PacketCategory.AUTH, operation = PacketOPCode.AUTH_ASK_AUTH)
public class C2SAskAuthPacket implements Packet {

    public static final ByteRange UNKNOWN_1_RANGE = ByteRange.of(0, 4);
    public static final ByteRange NAME_RANGE = ByteRange.of(4, 54);
    public static final ByteRange UNKNOWN_2_RANGE = ByteRange.of(54);
    public static final ByteRange PASSWORD_RANGE = ByteRange.of(55, 71);
    public static final ByteRange UNKNOWN_3_RANGE = ByteRange.of(71, 79);

    private final FixedLengthField unknown1;
    private final FixedLengthField name;
    private final FixedLengthField unknown2;
    private final FixedLengthField password;
    private final FixedLengthField unknown3;

    public C2SAskAuthPacket(final byte[] value) {
        this.unknown1 = new FixedLengthField(UNKNOWN_1_RANGE, value);
        this.name = new FixedLengthField(NAME_RANGE, value);
        this.unknown2 = new FixedLengthField(UNKNOWN_2_RANGE, value);
        this.password = new FixedLengthField(PASSWORD_RANGE, value);
        this.unknown3 = new FixedLengthField(UNKNOWN_3_RANGE, value);
    }
}
