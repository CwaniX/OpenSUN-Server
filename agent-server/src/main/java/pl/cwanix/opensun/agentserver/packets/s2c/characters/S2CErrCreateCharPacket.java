package pl.cwanix.opensun.agentserver.packets.s2c.characters;

import org.apache.commons.lang3.ArrayUtils;
import pl.cwanix.opensun.commonserver.packets.Packet;
import pl.cwanix.opensun.commonserver.packets.PacketCategory;
import pl.cwanix.opensun.commonserver.packets.annotations.OutgoingPacket;
import pl.cwanix.opensun.utils.datatypes.FixedLengthField;

@SuppressWarnings("checkstyle:MagicNumber")
@OutgoingPacket(category = PacketCategory.CHARACTER, type = (byte) 0x71)
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
