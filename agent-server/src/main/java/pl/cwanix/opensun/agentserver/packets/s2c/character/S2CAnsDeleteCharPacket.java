package pl.cwanix.opensun.agentserver.packets.s2c.character;

import pl.cwanix.opensun.agentserver.packets.AgentServerPacketOPCode;
import pl.cwanix.opensun.commonserver.packets.Packet;
import pl.cwanix.opensun.commonserver.packets.annotations.OutgoingPacket;

@SuppressWarnings("checkstyle:MagicNumber")
@OutgoingPacket(category = AgentServerPacketOPCode.Character.CATEGORY, operation = AgentServerPacketOPCode.Character.Ans.DELETE_CHAR)
public class S2CAnsDeleteCharPacket implements Packet {

    @Override
    public Object[] getOrderedFields() {
        return null;
    }
}
