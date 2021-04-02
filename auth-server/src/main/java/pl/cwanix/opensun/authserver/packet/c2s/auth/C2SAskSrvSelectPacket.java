package pl.cwanix.opensun.authserver.packet.c2s.auth;

import lombok.Getter;
import pl.cwanix.opensun.authserver.packet.AuthServerPacketOPCode;
import pl.cwanix.opensun.commonserver.packets.Packet;
import pl.cwanix.opensun.commonserver.packets.annotations.IncomingPacket;
import pl.cwanix.opensun.utils.bytes.ByteRange;
import pl.cwanix.opensun.utils.datatypes.FixedLengthField;

@Getter
@IncomingPacket(category = AuthServerPacketOPCode.Auth.CATEGORY, operation = AuthServerPacketOPCode.Auth.Ask.SRV_SELECT)
public class C2SAskSrvSelectPacket implements Packet {

    private static final ByteRange SERVER_INDEX_RANGE = ByteRange.of(0);
    private static final ByteRange CHANNEL_INDEX_RANGE = ByteRange.of(1);

    private final FixedLengthField serverIndex;
    private final FixedLengthField channelIndex;

    public C2SAskSrvSelectPacket(final byte[] value) {
        this.serverIndex = new FixedLengthField(SERVER_INDEX_RANGE, value);
        this.channelIndex = new FixedLengthField(CHANNEL_INDEX_RANGE, value);
    }
}
