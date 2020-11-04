package pl.cwanix.opensun.worldserver.packets.c2s.sync;

import pl.cwanix.opensun.commonserver.packets.Packet;
import pl.cwanix.opensun.commonserver.packets.PacketCategory;
import pl.cwanix.opensun.commonserver.packets.annotations.IncomingPacket;
import pl.cwanix.opensun.commonserver.packets.annotations.PacketOPCode;

@IncomingPacket(category = PacketCategory.CONNECTION, operation = PacketOPCode.CONNECTION_4860)
public class C2S4860Packet implements Packet {

    public C2S4860Packet(final byte[] value) {
        // TODO Auto-generated constructor stub
    }
}
