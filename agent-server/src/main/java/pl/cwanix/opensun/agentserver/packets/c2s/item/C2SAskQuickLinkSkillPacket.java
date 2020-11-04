package pl.cwanix.opensun.agentserver.packets.c2s.item;

import lombok.Getter;
import pl.cwanix.opensun.commonserver.packets.Packet;
import pl.cwanix.opensun.commonserver.packets.PacketCategory;
import pl.cwanix.opensun.commonserver.packets.annotations.IncomingPacket;
import pl.cwanix.opensun.commonserver.packets.annotations.PacketOPCode;
import pl.cwanix.opensun.utils.datatypes.FixedLengthField;

@SuppressWarnings("checkstyle:MagicNumber")
@Getter
@IncomingPacket(category = PacketCategory.ITEM, operation = PacketOPCode.ITEM_ASK_QUICK_LINK_SKILL)
public class C2SAskQuickLinkSkillPacket implements Packet {

    private final FixedLengthField slotCode;
    private final FixedLengthField position;

    public C2SAskQuickLinkSkillPacket(final byte[] value) {
        this.slotCode = new FixedLengthField(2, 0, 2, value);
        this.position = new FixedLengthField(1, 2, value);
    }
}
