package pl.cwanix.opensun.agentserver.packets.c2s.character;

import pl.cwanix.opensun.commonserver.packets.Packet;
import pl.cwanix.opensun.commonserver.packets.PacketCategory;
import pl.cwanix.opensun.commonserver.packets.annotations.IncomingPacket;
import pl.cwanix.opensun.commonserver.packets.annotations.PacketOPCode;

@IncomingPacket(category = PacketCategory.CHARACTER, operation = PacketOPCode.CHARACTER_ASK_FREE_CHAR_NAME)
public class C2SAskFreeCharNamePacket implements Packet {

    public C2SAskFreeCharNamePacket(final byte[] value) {
        // TODO Auto-generated constructor stub
    }
}
