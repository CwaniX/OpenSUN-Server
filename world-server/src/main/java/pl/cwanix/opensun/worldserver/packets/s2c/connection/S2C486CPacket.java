package pl.cwanix.opensun.worldserver.packets.s2c.connection;

import pl.cwanix.opensun.commonserver.packets.Packet;
import pl.cwanix.opensun.commonserver.packets.annotations.OutgoingPacket;
import pl.cwanix.opensun.worldserver.packets.WorldServerPacketOPCode;

@OutgoingPacket(category = WorldServerPacketOPCode.Connection.CATEGORY, operation = WorldServerPacketOPCode.Connection.Unk.UNK_486C)
public class S2C486CPacket implements Packet {

    @Override
    public Object[] getOrderedFields() {
        return null;
    }
}
