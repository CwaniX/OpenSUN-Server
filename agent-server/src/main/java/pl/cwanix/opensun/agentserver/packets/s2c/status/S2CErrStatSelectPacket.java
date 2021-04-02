package pl.cwanix.opensun.agentserver.packets.s2c.status;

import org.apache.commons.lang3.ArrayUtils;
import pl.cwanix.opensun.agentserver.packets.AgentServerPacketOPCode;
import pl.cwanix.opensun.commonserver.packets.Packet;
import pl.cwanix.opensun.commonserver.packets.annotations.OutgoingPacket;
import pl.cwanix.opensun.utils.datatypes.FixedLengthField;

@SuppressWarnings("checkstyle:MagicNumber")
@OutgoingPacket(category = AgentServerPacketOPCode.Status.CATEGORY, operation = AgentServerPacketOPCode.Status.Err.STAT_SELECT)
public class S2CErrStatSelectPacket implements Packet {

    private final FixedLengthField attributeCode;
    private final FixedLengthField errorCode;

    public S2CErrStatSelectPacket(final byte attributeCode, final int errorCode) {
        this.attributeCode = new FixedLengthField(1, attributeCode);
        this.errorCode = new FixedLengthField(4, errorCode);
    }

    @Override
    public Object[] getOrderedFields() {
        return ArrayUtils.toArray(attributeCode, errorCode);
    }
}
