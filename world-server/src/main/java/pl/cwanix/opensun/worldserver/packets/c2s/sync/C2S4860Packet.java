package pl.cwanix.opensun.worldserver.packets.c2s.sync;

import pl.cwanix.opensun.commonserver.packets.Packet;
import pl.cwanix.opensun.commonserver.packets.PacketCategory;
import pl.cwanix.opensun.commonserver.packets.annotations.IncomingPacket;

@SuppressWarnings("checkstyle:MagicNumber")
@IncomingPacket(category = PacketCategory.CONNECTION, type = (byte) 0x60)
public class C2S4860Packet implements Packet {

    public C2S4860Packet(final byte[] value) {
        // TODO Auto-generated constructor stub
    }
}
