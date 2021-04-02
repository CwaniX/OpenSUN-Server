package pl.cwanix.opensun.agentserver.packets.c2s.sync;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import pl.cwanix.opensun.agentserver.packets.AgentServerPacketOPCode;
import pl.cwanix.opensun.commonserver.packets.Packet;
import pl.cwanix.opensun.commonserver.packets.annotations.IncomingPacket;
import pl.cwanix.opensun.utils.datatypes.FixedLengthField;
import pl.cwanix.opensun.utils.datatypes.Vector;

import java.util.Arrays;

@SuppressWarnings("checkstyle:MagicNumber")
@Slf4j
@Getter
@IncomingPacket(category = AgentServerPacketOPCode.Sync.CATEGORY, operation = AgentServerPacketOPCode.Sync.Ask.MOUSE_MOVE)
public class C2SAskMouseMovePacket implements Packet {

    private final FixedLengthField unknown;
    private final Vector currentPosition;
    private final Vector destinationPosition;

    public C2SAskMouseMovePacket(final byte[] value) {
        unknown = new FixedLengthField(2, value[0], value[1]);
        currentPosition = new Vector(Arrays.copyOfRange(value, 2, 14));
        destinationPosition = new Vector(Arrays.copyOfRange(value, 14, value.length));
    }
}
