package pl.cwanix.opensun.agentserver.packets.s2c.zone;

import org.apache.commons.lang3.ArrayUtils;
import pl.cwanix.opensun.commonserver.packets.Packet;
import pl.cwanix.opensun.commonserver.packets.PacketCategory;
import pl.cwanix.opensun.commonserver.packets.annotations.OutgoingPacket;
import pl.cwanix.opensun.utils.datatypes.FixedLengthField;

@SuppressWarnings("checkstyle:MagicNumber")
@OutgoingPacket(category = PacketCategory.ZONE, type = 0x6C)
public class S2CAnsVillageMovePacket implements Packet {

    private final FixedLengthField unknown;

    public S2CAnsVillageMovePacket() {
        this.unknown = new FixedLengthField(4, 104);
    }

    @Override
    public Object[] getOrderedFields() {
        return ArrayUtils.toArray(unknown);
    }
}
