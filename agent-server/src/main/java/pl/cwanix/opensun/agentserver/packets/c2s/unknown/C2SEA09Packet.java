package pl.cwanix.opensun.agentserver.packets.c2s.unknown;

import pl.cwanix.opensun.commonserver.packets.Packet;
import pl.cwanix.opensun.commonserver.packets.PacketCategory;
import pl.cwanix.opensun.commonserver.packets.annotations.IncomingPacket;
import pl.cwanix.opensun.commonserver.packets.annotations.PacketOPCode;

@IncomingPacket(category = PacketCategory.UNKNOWN, operation = PacketOPCode.UNKNOWN_EA09)
public class C2SEA09Packet implements Packet {

    public C2SEA09Packet(final byte[] value) {
        // TODO Auto-generated constructor stub
    }

}
