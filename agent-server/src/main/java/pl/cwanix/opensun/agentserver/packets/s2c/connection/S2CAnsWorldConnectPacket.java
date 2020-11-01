package pl.cwanix.opensun.agentserver.packets.s2c.connection;

import org.apache.commons.lang3.ArrayUtils;
import pl.cwanix.opensun.commonserver.packets.Packet;
import pl.cwanix.opensun.commonserver.packets.PacketCategory;
import pl.cwanix.opensun.commonserver.packets.annotations.OutgoingPacket;
import pl.cwanix.opensun.utils.datatypes.FixedLengthField;

@SuppressWarnings("checkstyle:MagicNumber")
@OutgoingPacket(category = PacketCategory.CONNECTION, type = 0x15)
public class S2CAnsWorldConnectPacket implements Packet {

    private final FixedLengthField worldServerIp;
    private final FixedLengthField worldServerPort;

    public S2CAnsWorldConnectPacket(final String ip, final int port) {
        this.worldServerIp = new FixedLengthField(32, ip);
        this.worldServerPort = new FixedLengthField(2, port);
    }

    @Override
    public Object[] getOrderedFields() {
        return ArrayUtils.toArray(worldServerIp, worldServerPort);
    }
}
