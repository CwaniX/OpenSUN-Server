package pl.cwanix.opensun.authserver.packet.structures;

import lombok.Getter;
import org.apache.commons.lang3.ArrayUtils;
import pl.cwanix.opensun.commonserver.packets.PacketStructure;
import pl.cwanix.opensun.domain.ServerDTO;
import pl.cwanix.opensun.utils.datatypes.FixedLengthField;

@SuppressWarnings("checkstyle:MagicNumber")
@Getter
public class ServerUnitStructure implements PacketStructure {

    private final FixedLengthField serverName;
    private final FixedLengthField unknown1;
    private final FixedLengthField serverId;
    private final FixedLengthField unknown2;

    public ServerUnitStructure(final ServerDTO server) {
        this.serverName = new FixedLengthField(32, server.getName());
        this.unknown1 = new FixedLengthField(1);
        this.serverId = new FixedLengthField(1, server.getId());
        this.unknown2 = new FixedLengthField(2);
    }

    @Override
    public Object[] getOrderedFields() {
        return ArrayUtils.toArray(serverName, unknown1, serverId, unknown2);
    }
}
