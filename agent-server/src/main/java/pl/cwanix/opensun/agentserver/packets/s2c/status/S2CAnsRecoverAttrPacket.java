package pl.cwanix.opensun.agentserver.packets.s2c.status;

import org.apache.commons.lang3.ArrayUtils;
import pl.cwanix.opensun.commonserver.packets.Packet;
import pl.cwanix.opensun.commonserver.packets.PacketCategory;
import pl.cwanix.opensun.commonserver.packets.annotations.OutgoingPacket;
import pl.cwanix.opensun.commonserver.packets.annotations.PacketOPCode;
import pl.cwanix.opensun.utils.datatypes.FixedLengthField;

@SuppressWarnings("checkstyle:MagicNumber")
@OutgoingPacket(category = PacketCategory.STATUS, operation = PacketOPCode.STATUS_ANS_RECOVER_ATTR)
public class S2CAnsRecoverAttrPacket implements Packet {

    private final FixedLengthField value;

    public S2CAnsRecoverAttrPacket() {
        value = new FixedLengthField(12,
                new byte[] {0x21, 0x00, 0x00, 0x00, (byte) 0x9e, 0x08, 0x00, 0x00,
                        (byte) 0x9e, 0x08, 0x00, 0x00});
    }

    @Override
    public Object[] getOrderedFields() {
        return ArrayUtils.toArray(value);
    }
}
