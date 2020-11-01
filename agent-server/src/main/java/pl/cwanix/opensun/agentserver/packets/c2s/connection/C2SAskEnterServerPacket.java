package pl.cwanix.opensun.agentserver.packets.c2s.connection;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import pl.cwanix.opensun.commonserver.packets.Packet;
import pl.cwanix.opensun.commonserver.packets.PacketCategory;
import pl.cwanix.opensun.commonserver.packets.annotations.IncomingPacket;
import pl.cwanix.opensun.utils.datatypes.FixedLengthField;

import java.util.Arrays;

@SuppressWarnings("checkstyle:MagicNumber")
@Slf4j
@Getter
@IncomingPacket(category = PacketCategory.CONNECTION, type = 0x76)
public class C2SAskEnterServerPacket implements Packet {

    private final FixedLengthField userId;
    private final FixedLengthField userName;

    public C2SAskEnterServerPacket(final byte[] value) {
        this.userId = new FixedLengthField(4, Arrays.copyOfRange(value, 2, 6));
        this.userName = new FixedLengthField(50, Arrays.copyOfRange(value, 7, 54));
    }
}
