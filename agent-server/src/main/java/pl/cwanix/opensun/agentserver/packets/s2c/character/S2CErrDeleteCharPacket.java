package pl.cwanix.opensun.agentserver.packets.s2c.character;

import org.apache.commons.lang3.ArrayUtils;
import pl.cwanix.opensun.commonserver.packets.Packet;
import pl.cwanix.opensun.utils.datatypes.FixedLengthField;

@SuppressWarnings("checkstyle:MagicNumber")
//@OutgoingPacket(category = PacketCategory.CHARACTER, type = 0x71)
public class S2CErrDeleteCharPacket implements Packet {

    private final FixedLengthField errorCode;

    public S2CErrDeleteCharPacket(final int errorCode) {
        this.errorCode = new FixedLengthField(4, errorCode);
    }

    @Override
    public Object[] getOrderedFields() {
        return ArrayUtils.toArray(errorCode);
    }
}
