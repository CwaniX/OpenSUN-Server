package pl.cwanix.opensun.authserver.packet.c2s.auth;

import lombok.Getter;
import pl.cwanix.opensun.commonserver.packets.Packet;
import pl.cwanix.opensun.commonserver.packets.PacketCategory;
import pl.cwanix.opensun.commonserver.packets.annotations.IncomingPacket;
import pl.cwanix.opensun.utils.datatypes.FixedLengthField;

@Getter
@SuppressWarnings("checkstyle:MagicNumber")
@IncomingPacket(category = PacketCategory.AUTH, type = 0x13)
public class C2SAskSrvSelectPacket implements Packet {

    private final FixedLengthField serverIndex;
    private final FixedLengthField channelIndex;

    public C2SAskSrvSelectPacket(final byte[] value) {
        this.serverIndex = new FixedLengthField(1, value[0]);
        this.channelIndex = new FixedLengthField(1, value[1]);
    }
}
