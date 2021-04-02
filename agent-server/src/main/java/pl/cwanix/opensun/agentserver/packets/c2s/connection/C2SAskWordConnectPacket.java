package pl.cwanix.opensun.agentserver.packets.c2s.connection;

import pl.cwanix.opensun.agentserver.packets.AgentServerPacketOPCode;
import pl.cwanix.opensun.commonserver.packets.Packet;
import pl.cwanix.opensun.commonserver.packets.annotations.IncomingPacket;

@IncomingPacket(category = AgentServerPacketOPCode.Connection.CATEGORY, operation = AgentServerPacketOPCode.Connection.Ask.WORLD_CONNECT)
public class C2SAskWordConnectPacket implements Packet  {

    public C2SAskWordConnectPacket(final byte[] value) {
        // TODO Auto-generated constructor stub
    }
}
