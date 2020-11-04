package pl.cwanix.opensun.agentserver.packets.c2s.connection;

import pl.cwanix.opensun.commonserver.packets.Packet;
import pl.cwanix.opensun.commonserver.packets.PacketCategory;
import pl.cwanix.opensun.commonserver.packets.annotations.IncomingPacket;
import pl.cwanix.opensun.commonserver.packets.annotations.PacketOPCode;

@IncomingPacket(category = PacketCategory.CONNECTION, operation = PacketOPCode.CONNECTION_ASK_WORLD_CONNECT)
public class C2SAskWordConnectPacket implements Packet  {

    public C2SAskWordConnectPacket(final byte[] value) {
        // TODO Auto-generated constructor stub
    }
}
