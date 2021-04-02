package pl.cwanix.opensun.worldserver.packets.c2s.sync;

import pl.cwanix.opensun.commonserver.packets.Packet;
import pl.cwanix.opensun.commonserver.packets.annotations.IncomingPacket;
import pl.cwanix.opensun.worldserver.packets.WorldServerPacketOPCode;

@IncomingPacket(category = WorldServerPacketOPCode.Sync.CATEGORY, operation = WorldServerPacketOPCode.Sync.Unk._FD60)
public class C2SFD60Packet implements Packet {

    public C2SFD60Packet(final byte[] value) {
        // TODO Auto-generated constructor stub
    }
}
