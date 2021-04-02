package pl.cwanix.opensun.agentserver.packets.s2c.character;

import org.apache.commons.lang3.ArrayUtils;
import pl.cwanix.opensun.agentserver.packets.AgentServerPacketOPCode;
import pl.cwanix.opensun.commonserver.packets.Packet;
import pl.cwanix.opensun.commonserver.packets.annotations.OutgoingPacket;
import pl.cwanix.opensun.utils.datatypes.FixedLengthField;

@SuppressWarnings("checkstyle:MagicNumber")
@OutgoingPacket(category = AgentServerPacketOPCode.Character.CATEGORY, operation = AgentServerPacketOPCode.Character.Ans.SKILLS)
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
