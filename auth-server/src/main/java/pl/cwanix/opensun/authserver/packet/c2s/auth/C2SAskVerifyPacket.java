package pl.cwanix.opensun.authserver.packet.c2s.auth;

import pl.cwanix.opensun.commonserver.packets.Packet;
import pl.cwanix.opensun.commonserver.packets.PacketCategory;
import pl.cwanix.opensun.commonserver.packets.annotations.IncomingPacket;
import pl.cwanix.opensun.utils.datatypes.FixedLengthField;

import java.util.Arrays;

@SuppressWarnings("checkstyle:MagicNumber")
@IncomingPacket(category = PacketCategory.AUTH, type = 0x01)
public class C2SAskVerifyPacket implements Packet {

    private final FixedLengthField clientVersion;
    private final FixedLengthField clientIpAddress;

    public C2SAskVerifyPacket(final byte[] value) {
        this.clientVersion = new FixedLengthField(4, Arrays.copyOfRange(value, 0, 4));
        this.clientIpAddress = new FixedLengthField(16, Arrays.copyOfRange(value, 4, value.length));
    }
}
