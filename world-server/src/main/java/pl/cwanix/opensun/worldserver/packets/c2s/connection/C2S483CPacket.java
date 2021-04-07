package pl.cwanix.opensun.worldserver.packets.c2s.connection;

import pl.cwanix.opensun.commonserver.packets.Packet;
import pl.cwanix.opensun.commonserver.packets.annotations.IncomingPacket;
import pl.cwanix.opensun.worldserver.packets.WorldServerPacketOPCode;

@IncomingPacket(category = WorldServerPacketOPCode.Connection.CATEGORY, operation = WorldServerPacketOPCode.Connection.Unk.UNK_483C)
public class C2S483CPacket implements Packet {

    public C2S483CPacket(final byte[] value) {
        // TODO Auto-generated constructor stub
    }
}
