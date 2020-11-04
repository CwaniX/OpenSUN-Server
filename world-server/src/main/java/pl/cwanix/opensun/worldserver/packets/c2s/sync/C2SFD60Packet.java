package pl.cwanix.opensun.worldserver.packets.c2s.sync;

import pl.cwanix.opensun.commonserver.packets.Packet;
import pl.cwanix.opensun.commonserver.packets.PacketCategory;
import pl.cwanix.opensun.commonserver.packets.annotations.IncomingPacket;
import pl.cwanix.opensun.commonserver.packets.annotations.PacketOPCode;

@IncomingPacket(category = PacketCategory.SYNC, operation = PacketOPCode.SYNC_FD60)
public class C2SFD60Packet implements Packet {

    public C2SFD60Packet(final byte[] value) {
        // TODO Auto-generated constructor stub
    }
}
