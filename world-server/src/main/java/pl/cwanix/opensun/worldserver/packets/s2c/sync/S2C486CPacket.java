package pl.cwanix.opensun.worldserver.packets.s2c.sync;

import pl.cwanix.opensun.commonserver.packets.Packet;
import pl.cwanix.opensun.commonserver.packets.PacketCategory;
import pl.cwanix.opensun.commonserver.packets.annotations.OutgoingPacket;

@SuppressWarnings("checkstyle:MagicNumber")
@OutgoingPacket(category = PacketCategory.CONNECTION, type = (byte) 0x6C)
public class S2C486CPacket implements Packet {

    @Override
    public Object[] getOrderedFields() {
        return null;
    }
}
