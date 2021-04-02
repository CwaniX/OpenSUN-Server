package pl.cwanix.opensun.agentserver.packets.s2c.character;

import org.apache.commons.lang3.ArrayUtils;
import pl.cwanix.opensun.agentserver.packets.AgentServerPacketOPCode;
import pl.cwanix.opensun.commonserver.packets.Packet;
import pl.cwanix.opensun.commonserver.packets.annotations.OutgoingPacket;
import pl.cwanix.opensun.utils.datatypes.FixedLengthField;

@SuppressWarnings("checkstyle:MagicNumber")
@OutgoingPacket(category = AgentServerPacketOPCode.Character.CATEGORY, operation = AgentServerPacketOPCode.Character.Err.CREATE_CHAR)
public class S2CErrCreateCharPacket implements Packet {

    private final FixedLengthField errorCode;

    public S2CErrCreateCharPacket() {
        errorCode = new FixedLengthField(4);
    }

    @Override
    public Object[] getOrderedFields() {
        return ArrayUtils.toArray(errorCode);
    }
}
