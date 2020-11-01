package pl.cwanix.opensun.agentserver.packets.c2s.character;

import pl.cwanix.opensun.commonserver.packets.Packet;
import pl.cwanix.opensun.commonserver.packets.PacketCategory;
import pl.cwanix.opensun.commonserver.packets.annotations.IncomingPacket;

@SuppressWarnings("checkstyle:MagicNumber")
@IncomingPacket(category = PacketCategory.CHARACTER, type = 0x51)
public class C2SAskFreeCharNamePacket implements Packet {

    public C2SAskFreeCharNamePacket(final byte[] value) {
        // TODO Auto-generated constructor stub
    }
}
