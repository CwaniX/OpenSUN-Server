package pl.cwanix.opensun.worldserver.packets.c2s.sync;

import pl.cwanix.opensun.commonserver.packets.Packet;
import pl.cwanix.opensun.commonserver.packets.PacketCategory;
import pl.cwanix.opensun.commonserver.packets.annotations.IncomingPacket;
import pl.cwanix.opensun.commonserver.packets.annotations.PacketOPCode;

@IncomingPacket(category = PacketCategory.CONNECTION, operation = PacketOPCode.CONNECTION_483C)
public class C2S483CPacket implements Packet {

    public C2S483CPacket(final byte[] value) {
        // TODO Auto-generated constructor stub
    }
}
