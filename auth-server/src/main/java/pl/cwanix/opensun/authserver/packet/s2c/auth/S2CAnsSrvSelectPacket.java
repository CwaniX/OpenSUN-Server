package pl.cwanix.opensun.authserver.packet.s2c.auth;

import org.apache.commons.lang3.ArrayUtils;
import pl.cwanix.opensun.authserver.packet.AuthServerPacketOPCode;
import pl.cwanix.opensun.commonserver.packets.Packet;
import pl.cwanix.opensun.commonserver.packets.annotations.OutgoingPacket;
import pl.cwanix.opensun.utils.datatypes.FixedLengthField;

@SuppressWarnings({"checkstyle:MagicNumber", "checkstyle:LineLength"})
@OutgoingPacket(category = AuthServerPacketOPCode.Auth.CATEGORY, operation = AuthServerPacketOPCode.Auth.Ans.SRV_SELECT)
public class S2CAnsSrvSelectPacket implements Packet {

    private final FixedLengthField userId;
    private final FixedLengthField unknownString;
    private final FixedLengthField serverIp;
    private final FixedLengthField serverPort;

    public S2CAnsSrvSelectPacket(final int userId, final String serverIp, final int port) {
        this.userId = new FixedLengthField(4, userId);
        this.unknownString = new FixedLengthField(32, new byte[] {0x30, 0x00, 0x20, 0x00, 0x00, 0x20, 0x00, 0x00, 0x20, (byte) 0x81, 0x07, 0x20, 0x42, 0x00, 0x20, 0x0f, 0x00, 0x20, 0x00, 0x00, 0x20, 0x00, 0x00, 0x20, 0x00, 0x00, 0x20, 0x0e, 0x00, 0x20, 0x07, 0x08});
        this.serverIp = new FixedLengthField(32, serverIp);
        this.serverPort = new FixedLengthField(5, port);
    }

    @Override
    public Object[] getOrderedFields() {
        return ArrayUtils.toArray(userId, unknownString, serverIp, serverPort);
    }
}
