package pl.cwanix.opensun.agentserver.packets.c2s.character;

import pl.cwanix.opensun.agentserver.packets.AgentServerPacketOPCode;
import pl.cwanix.opensun.commonserver.packets.Packet;
import pl.cwanix.opensun.commonserver.packets.annotations.IncomingPacket;

@IncomingPacket(category = AgentServerPacketOPCode.Character.CATEGORY, operation = AgentServerPacketOPCode.Character.Ask.FREE_CHAR_NAME)
public class C2SAskFreeCharNamePacket implements Packet {

    public C2SAskFreeCharNamePacket(final byte[] value) {
        // TODO Auto-generated constructor stub
    }
}
