package pl.cwanix.opensun.agentserver.packets.s2c.zone;

import org.apache.commons.lang3.ArrayUtils;
import pl.cwanix.opensun.agentserver.packets.AgentServerPacketOPCode;
import pl.cwanix.opensun.commonserver.packets.Packet;
import pl.cwanix.opensun.commonserver.packets.annotations.OutgoingPacket;
import pl.cwanix.opensun.utils.datatypes.FixedLengthField;

@SuppressWarnings("checkstyle:MagicNumber")
@OutgoingPacket(category = AgentServerPacketOPCode.Zone.CATEGORY, operation = AgentServerPacketOPCode.Zone.Ans.VILLAGE_MOVE)
public class S2CAnsVillageMovePacket implements Packet {

    private final FixedLengthField fieldCode;

    public S2CAnsVillageMovePacket(int fieldCode) {
        this.fieldCode = new FixedLengthField(4, fieldCode);
    }

    @Override
    public Object[] getOrderedFields() {
        return ArrayUtils.toArray(fieldCode);
    }
}
