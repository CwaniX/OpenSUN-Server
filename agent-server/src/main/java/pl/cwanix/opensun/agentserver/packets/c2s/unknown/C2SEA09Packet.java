package pl.cwanix.opensun.agentserver.packets.c2s.unknown;

import pl.cwanix.opensun.agentserver.packets.AgentServerPacketOPCode;
import pl.cwanix.opensun.commonserver.packets.Packet;
import pl.cwanix.opensun.commonserver.packets.annotations.IncomingPacket;

@IncomingPacket(category = AgentServerPacketOPCode.Unknown.CATEGORY, operation = AgentServerPacketOPCode.Unknown.Unk.UNK_EA09)
public class C2SEA09Packet implements Packet {

    public C2SEA09Packet(final byte[] value) {
        // TODO Auto-generated constructor stub
    }

}
