package pl.cwanix.opensun.agentserver.packets.s2c.zone;

import pl.cwanix.opensun.commonserver.packets.Packet;
import pl.cwanix.opensun.commonserver.packets.PacketCategory;
import pl.cwanix.opensun.commonserver.packets.annotations.OutgoingPacket;
import pl.cwanix.opensun.commonserver.packets.annotations.PacketOPCode;

@SuppressWarnings("checkstyle:MagicNumber")
@OutgoingPacket(category = PacketCategory.ZONE, operation = PacketOPCode.ZONE_ERR_VILLAGE_MOVE) //TODO: ?
public class S2CErrVillageMovePacket implements Packet {

    public S2CErrVillageMovePacket() {
    }

    @Override
    public Object[] getOrderedFields() {
        return null;
    }
}
