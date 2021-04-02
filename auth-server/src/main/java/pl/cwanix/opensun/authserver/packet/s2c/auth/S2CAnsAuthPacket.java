package pl.cwanix.opensun.authserver.packet.s2c.auth;

import org.apache.commons.lang3.ArrayUtils;
import pl.cwanix.opensun.authserver.packet.AuthServerPacketOPCode;
import pl.cwanix.opensun.commonserver.packets.Packet;
import pl.cwanix.opensun.commonserver.packets.annotations.OutgoingPacket;
import pl.cwanix.opensun.utils.datatypes.FixedLengthField;

@SuppressWarnings("checkstyle:MagicNumber")
@OutgoingPacket(category = AuthServerPacketOPCode.Auth.CATEGORY, operation = AuthServerPacketOPCode.Auth.Ans.AUTH)
public class S2CAnsAuthPacket implements Packet {

    private final FixedLengthField result;
    private final FixedLengthField info;

    public S2CAnsAuthPacket(final int resultCode) {
        this.result = new FixedLengthField(1, resultCode);
        this.info = new FixedLengthField(64);
    }

    @Override
    public Object[] getOrderedFields() {
        return ArrayUtils.toArray(result, info);
    }
}
