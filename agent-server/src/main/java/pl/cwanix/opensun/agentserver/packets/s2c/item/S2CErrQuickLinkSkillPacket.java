package pl.cwanix.opensun.agentserver.packets.s2c.item;

import org.apache.commons.lang3.ArrayUtils;
import pl.cwanix.opensun.agentserver.packets.AgentServerPacketOPCode;
import pl.cwanix.opensun.commonserver.packets.Packet;
import pl.cwanix.opensun.commonserver.packets.annotations.OutgoingPacket;
import pl.cwanix.opensun.utils.datatypes.FixedLengthField;

@SuppressWarnings("checkstyle:MagicNumber")
@OutgoingPacket(category = AgentServerPacketOPCode.Item.CATEGORY, operation = AgentServerPacketOPCode.Item.Err.QUICK_LINK_SKILL)
public class S2CErrQuickLinkSkillPacket implements Packet {

    private final FixedLengthField errorCode;

    public S2CErrQuickLinkSkillPacket(final int errorCode) {
        this.errorCode = new FixedLengthField(4, errorCode);
    }

    @Override
    public Object[] getOrderedFields() {
        return ArrayUtils.toArray(errorCode);
    }
}
