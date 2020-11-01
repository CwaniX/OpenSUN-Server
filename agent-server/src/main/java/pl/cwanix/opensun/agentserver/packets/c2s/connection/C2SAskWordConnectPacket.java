package pl.cwanix.opensun.agentserver.packets.c2s.connection;

import pl.cwanix.opensun.commonserver.packets.Packet;
import pl.cwanix.opensun.commonserver.packets.PacketCategory;
import pl.cwanix.opensun.commonserver.packets.annotations.IncomingPacket;

@SuppressWarnings("checkstyle:MagicNumber")
@IncomingPacket(category = PacketCategory.CONNECTION, type = (byte) 0xDF)
public class C2SAskWordConnectPacket implements Packet  {

    public C2SAskWordConnectPacket(final byte[] value) {
        // TODO Auto-generated constructor stub
    }
}
