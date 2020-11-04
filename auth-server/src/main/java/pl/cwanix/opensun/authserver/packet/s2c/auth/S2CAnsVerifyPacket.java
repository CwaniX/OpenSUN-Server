package pl.cwanix.opensun.authserver.packet.s2c.auth;

import org.apache.commons.lang3.ArrayUtils;
import pl.cwanix.opensun.commonserver.packets.Packet;
import pl.cwanix.opensun.commonserver.packets.PacketCategory;
import pl.cwanix.opensun.commonserver.packets.annotations.OutgoingPacket;
import pl.cwanix.opensun.commonserver.packets.annotations.PacketOPCode;
import pl.cwanix.opensun.utils.datatypes.FixedLengthField;

@SuppressWarnings("checkstyle:MagicNumber")
@OutgoingPacket(category = PacketCategory.AUTH, operation = PacketOPCode.AUTH_ANS_VERIFY)
public class S2CAnsVerifyPacket implements Packet {

    private final FixedLengthField result;

    public S2CAnsVerifyPacket() {
        this.result = new FixedLengthField(1, (byte) 0x00);
    }

    @Override
    public Object[] getOrderedFields() {
        return ArrayUtils.toArray(result);
    }
}
