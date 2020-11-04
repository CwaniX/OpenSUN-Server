package pl.cwanix.opensun.worldserver.packets.s2c.sync;

import pl.cwanix.opensun.commonserver.packets.Packet;
import pl.cwanix.opensun.commonserver.packets.PacketCategory;
import pl.cwanix.opensun.commonserver.packets.annotations.OutgoingPacket;
import pl.cwanix.opensun.commonserver.packets.annotations.PacketOPCode;

@OutgoingPacket(category = PacketCategory.CONNECTION, operation = PacketOPCode.CONNECTION_486C)
public class S2C486CPacket implements Packet {

    @Override
    public Object[] getOrderedFields() {
        return null;
    }
}
