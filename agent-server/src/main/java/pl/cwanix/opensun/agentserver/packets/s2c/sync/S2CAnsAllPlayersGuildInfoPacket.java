package pl.cwanix.opensun.agentserver.packets.s2c.sync;

import org.apache.commons.lang3.ArrayUtils;
import pl.cwanix.opensun.commonserver.packets.Packet;
import pl.cwanix.opensun.commonserver.packets.PacketCategory;
import pl.cwanix.opensun.commonserver.packets.annotations.OutgoingPacket;
import pl.cwanix.opensun.utils.datatypes.FixedLengthField;

@SuppressWarnings("checkstyle:MagicNumber")
@OutgoingPacket(category = PacketCategory.SYNC, type = (byte) 0xEA)
public class S2CAnsAllPlayersGuildInfoPacket implements Packet {

    private final FixedLengthField value;

    public S2CAnsAllPlayersGuildInfoPacket() {
        value = new FixedLengthField(42,
                new byte[] {0x01, 0x03, 0x00, 0x00, 0x00, (byte) 0xb8, 0x5c, 0x00, 0x00, (byte) 0xbc,
                        0x00, 0x00, 0x00, 0x60, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, (byte) 0xc7, (byte) 0xe9,
                        (byte) 0xd2, (byte) 0xe5, (byte) 0xd3, (byte) 0xc0, (byte) 0xba, (byte) 0xe3, 0x00, 0x00, 0x00,
                        0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x03, 0x04, 0x00, 0x00});
    }

    @Override
    public Object[] getOrderedFields() {
        return ArrayUtils.toArray(value);
    }
}
