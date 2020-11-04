package pl.cwanix.opensun.agentserver.packets.s2c.sync;

import org.apache.commons.lang3.ArrayUtils;
import pl.cwanix.opensun.commonserver.packets.Packet;
import pl.cwanix.opensun.commonserver.packets.PacketCategory;
import pl.cwanix.opensun.commonserver.packets.annotations.OutgoingPacket;
import pl.cwanix.opensun.commonserver.packets.annotations.PacketOPCode;
import pl.cwanix.opensun.utils.datatypes.FixedLengthField;

@SuppressWarnings("checkstyle:MagicNumber")
@OutgoingPacket(category = PacketCategory.SYNC, operation = PacketOPCode.SYNC_ANS_ALL_PLAYERS_EQUIP_INFO)
public class S2CAnsAllPlayersEquipInfoPacket implements Packet {

    //private FixedLengthField count;
    //private RenderEquipInfoPacketStructure equip;

    private final FixedLengthField value;

    public S2CAnsAllPlayersEquipInfoPacket() {
        value = new FixedLengthField(42,
                new byte[] {0x01,
                        0x04, 0x00, 0x00, 0x00,
                        0x09,
                        0x00, (byte) 0x89, 0x00, 0x0c,
                        0x00,
                        0x01, (byte) 0xb5,
                        (byte) 0xe8, 0x0c, 0x00, 0x02,
                        (byte) 0xb6,
                        (byte) 0xe8, 0x0c, 0x00, 0x03,
                        (byte) 0xb7,
                        (byte) 0xe8, 0x0c, 0x00, 0x04,
                        (byte) 0xb8,
                        (byte) 0xe8, 0x0c, 0x00, 0x05,
                        (byte) 0xb9,
                        (byte) 0xe8, 0x0c, 0x00, 0x06,
                        (byte) 0xba,
                        (byte) 0xe8, 0x0c, 0x00, 0x07});
    }

    @Override
    public Object[] getOrderedFields() {
        return ArrayUtils.toArray(value);
    }
}
