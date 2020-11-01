package pl.cwanix.opensun.agentserver.packets.c2s.sync;

import pl.cwanix.opensun.commonserver.packets.Packet;
import pl.cwanix.opensun.commonserver.packets.PacketCategory;
import pl.cwanix.opensun.commonserver.packets.annotations.IncomingPacket;

@SuppressWarnings("checkstyle:MagicNumber")
@IncomingPacket(category = PacketCategory.SYNC, type = 0x73)
public class C2SAskJumpMovePacket implements Packet {

    public C2SAskJumpMovePacket(final byte[] value) {
        // TODO Auto-generated constructor stub
    }

}
