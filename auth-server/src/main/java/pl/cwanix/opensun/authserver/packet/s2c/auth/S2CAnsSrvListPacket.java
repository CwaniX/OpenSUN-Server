package pl.cwanix.opensun.authserver.packet.s2c.auth;

import org.apache.commons.lang3.ArrayUtils;
import pl.cwanix.opensun.authserver.packet.structures.ServerUnitStructure;
import pl.cwanix.opensun.commonserver.packets.Packet;
import pl.cwanix.opensun.commonserver.packets.PacketCategory;
import pl.cwanix.opensun.commonserver.packets.annotations.OutgoingPacket;
import pl.cwanix.opensun.utils.datatypes.FixedLengthField;

import java.util.List;

@SuppressWarnings("checkstyle:MagicNumber")
@OutgoingPacket(category = PacketCategory.AUTH, type = 0x11)
public class S2CAnsSrvListPacket implements Packet {

    private final FixedLengthField serversCount;
    private final List<ServerUnitStructure> serversList;

    public S2CAnsSrvListPacket(final List<ServerUnitStructure> serversList) {
        this.serversCount = new FixedLengthField(1, serversList.size());
        this.serversList = serversList;
    }

    @Override
    public Object[] getOrderedFields() {
        return ArrayUtils.toArray(serversCount, serversList);
    }
}
