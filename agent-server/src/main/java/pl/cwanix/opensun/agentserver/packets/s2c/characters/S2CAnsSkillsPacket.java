package pl.cwanix.opensun.agentserver.packets.s2c.characters;

import org.apache.commons.lang3.ArrayUtils;
import pl.cwanix.opensun.commonserver.packets.Packet;
import pl.cwanix.opensun.commonserver.packets.PacketCategory;
import pl.cwanix.opensun.commonserver.packets.annotations.OutgoingPacket;
import pl.cwanix.opensun.commonserver.packets.annotations.PacketOPCode;
import pl.cwanix.opensun.utils.datatypes.FixedLengthField;

@SuppressWarnings("checkstyle:MagicNumber")
@OutgoingPacket(category = PacketCategory.CHARACTER, operation = PacketOPCode.CHARACTER_ANS_SKILLS)
public class S2CAnsSkillsPacket implements Packet {

    private final FixedLengthField value;

    public S2CAnsSkillsPacket() {
        value = new FixedLengthField(4, new byte[] {0x01, 0x00, (byte) 0xe1, 0x2e});
    }

    @Override
    public Object[] getOrderedFields() {
        return ArrayUtils.toArray(value);
    }
}
