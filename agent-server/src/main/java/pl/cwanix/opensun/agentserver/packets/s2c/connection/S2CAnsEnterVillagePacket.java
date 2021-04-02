package pl.cwanix.opensun.agentserver.packets.s2c.connection;

import org.apache.commons.lang3.ArrayUtils;
import pl.cwanix.opensun.agentserver.packets.AgentServerPacketOPCode;
import pl.cwanix.opensun.commonserver.packets.Packet;
import pl.cwanix.opensun.commonserver.packets.annotations.OutgoingPacket;
import pl.cwanix.opensun.utils.datatypes.FixedLengthField;

@SuppressWarnings("checkstyle:MagicNumber")
@OutgoingPacket(category = AgentServerPacketOPCode.Connection.CATEGORY, operation = AgentServerPacketOPCode.Connection.Ans.ENTER_VILLAGE)
public class S2CAnsEnterVillagePacket implements Packet {

    private final FixedLengthField playerKey;

    public S2CAnsEnterVillagePacket(final int playerKey) {
        this.playerKey = new FixedLengthField(4, playerKey);
    }

    @Override
    public Object[] getOrderedFields() {
        return ArrayUtils.toArray(playerKey);
    }
}
