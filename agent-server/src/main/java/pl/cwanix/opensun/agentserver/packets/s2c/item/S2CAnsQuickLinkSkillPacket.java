package pl.cwanix.opensun.agentserver.packets.s2c.item;

import org.apache.commons.lang3.ArrayUtils;
import pl.cwanix.opensun.commonserver.packets.Packet;
import pl.cwanix.opensun.commonserver.packets.PacketCategory;
import pl.cwanix.opensun.commonserver.packets.annotations.OutgoingPacket;
import pl.cwanix.opensun.commonserver.packets.annotations.PacketOPCode;
import pl.cwanix.opensun.utils.datatypes.FixedLengthField;

@SuppressWarnings("checkstyle:MagicNumber")
@OutgoingPacket(category = PacketCategory.ITEM, operation = PacketOPCode.ITEM_ANS_QUICK_LINK_SKILL)
public class S2CAnsQuickLinkSkillPacket implements Packet {

    private final FixedLengthField slotCode;
    private final FixedLengthField position;

    public S2CAnsQuickLinkSkillPacket(final int slotCode, final byte position) {
        this.slotCode = new FixedLengthField(2, slotCode);
        this.position = new FixedLengthField(1, position);
    }

    @Override
    public Object[] getOrderedFields() {
        return ArrayUtils.toArray(slotCode, position);
    }
}
