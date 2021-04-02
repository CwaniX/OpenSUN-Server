package pl.cwanix.opensun.agentserver.packets.c2s.sync;

import pl.cwanix.opensun.agentserver.packets.AgentServerPacketOPCode;
import pl.cwanix.opensun.commonserver.packets.Packet;
import pl.cwanix.opensun.commonserver.packets.annotations.IncomingPacket;

@IncomingPacket(category = AgentServerPacketOPCode.Sync.CATEGORY, operation = AgentServerPacketOPCode.Sync.Ask.JUMP_MOVE)
public class C2SAskJumpMovePacket implements Packet {

    public C2SAskJumpMovePacket(final byte[] value) {
        // TODO Auto-generated constructor stub
    }

}
