package pl.cwanix.opensun.authserver.packet.s2c.auth;

import org.apache.commons.lang3.ArrayUtils;
import pl.cwanix.opensun.authserver.packet.AuthServerPacketOPCode;
import pl.cwanix.opensun.commonserver.packets.Packet;
import pl.cwanix.opensun.commonserver.packets.annotations.OutgoingPacket;
import pl.cwanix.opensun.utils.datatypes.FixedLengthField;

@SuppressWarnings("checkstyle:MagicNumber")
@OutgoingPacket(category = AuthServerPacketOPCode.Auth.CATEGORY, operation = AuthServerPacketOPCode.Auth.Ans.HELLO)
public class S2CAnsHelloPacket implements Packet {

    private final FixedLengthField serverInfo;
    private final FixedLengthField encKey;

    public S2CAnsHelloPacket(final byte[] encKey) {
        this.serverInfo = new FixedLengthField(64);
        this.encKey = new FixedLengthField(4, encKey);
    }

    @Override
    public Object[] getOrderedFields() {
        return ArrayUtils.toArray(serverInfo, encKey);
    }
}
