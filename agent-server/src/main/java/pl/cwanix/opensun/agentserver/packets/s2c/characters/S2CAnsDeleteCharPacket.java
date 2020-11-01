package pl.cwanix.opensun.agentserver.packets.s2c.characters;

import pl.cwanix.opensun.commonserver.packets.Packet;
import pl.cwanix.opensun.commonserver.packets.PacketCategory;
import pl.cwanix.opensun.commonserver.packets.annotations.OutgoingPacket;

@SuppressWarnings("checkstyle:MagicNumber")
@OutgoingPacket(category = PacketCategory.CHARACTER, type = 0x07)
public class S2CAnsDeleteCharPacket implements Packet {

    @Override
    public Object[] getOrderedFields() {
        return null;
    }
}
