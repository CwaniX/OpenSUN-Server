package pl.cwanix.opensun.authserver.packet.c2s.auth;

import lombok.Getter;
import pl.cwanix.opensun.commonserver.packets.Packet;
import pl.cwanix.opensun.commonserver.packets.PacketCategory;
import pl.cwanix.opensun.commonserver.packets.annotations.IncomingPacket;
import pl.cwanix.opensun.commonserver.packets.annotations.PacketOPCode;
import pl.cwanix.opensun.utils.bytes.ByteRange;
import pl.cwanix.opensun.utils.datatypes.FixedLengthField;

@Getter
@IncomingPacket(category = PacketCategory.AUTH, operation = PacketOPCode.AUTH_ASK_VERIFY)
public class C2SAskVerifyPacket implements Packet {

    private static final ByteRange CLIENT_VERSION_RANGE = ByteRange.of(0, 4);
    private static final ByteRange CLIENT_IP_ADDRESS_RANGE = ByteRange.of(4, 20);

    private final FixedLengthField clientVersion;
    private final FixedLengthField clientIpAddress;

    public C2SAskVerifyPacket(final byte[] value) {
        this.clientVersion = new FixedLengthField(CLIENT_VERSION_RANGE, value);
        this.clientIpAddress = new FixedLengthField(CLIENT_IP_ADDRESS_RANGE, value);
    }
}
