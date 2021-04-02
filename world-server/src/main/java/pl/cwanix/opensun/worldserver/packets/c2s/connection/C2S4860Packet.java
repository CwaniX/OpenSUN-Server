package pl.cwanix.opensun.worldserver.packets.c2s.connection;

import pl.cwanix.opensun.commonserver.packets.Packet;
import pl.cwanix.opensun.commonserver.packets.annotations.IncomingPacket;
import pl.cwanix.opensun.worldserver.packets.WorldServerPacketOPCode;

@IncomingPacket(category = WorldServerPacketOPCode.Connection.CATEGORY, operation = WorldServerPacketOPCode.Connection.Unk._4860)
public class C2S4860Packet implements Packet {

    public C2S4860Packet(final byte[] value) {
        // TODO Auto-generated constructor stub
    }
}
