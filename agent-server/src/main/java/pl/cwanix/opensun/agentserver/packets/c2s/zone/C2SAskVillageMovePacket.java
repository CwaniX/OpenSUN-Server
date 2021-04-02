package pl.cwanix.opensun.agentserver.packets.c2s.zone;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Marker;
import org.slf4j.MarkerFactory;
import pl.cwanix.opensun.agentserver.packets.AgentServerPacketOPCode;
import pl.cwanix.opensun.commonserver.packets.Packet;
import pl.cwanix.opensun.commonserver.packets.annotations.IncomingPacket;
import pl.cwanix.opensun.utils.datatypes.FixedLengthField;

@SuppressWarnings("checkstyle:MagicNumber")
@Slf4j
@Getter
@IncomingPacket(category = AgentServerPacketOPCode.Zone.CATEGORY, operation = AgentServerPacketOPCode.Zone.Ask.VILLAGE_MOVE)
public class C2SAskVillageMovePacket implements Packet {

    private static final Marker MARKER = MarkerFactory.getMarker("C2S -> VILLAGE MOVE");

    private final FixedLengthField villageMapCode;

    public C2SAskVillageMovePacket(final byte[] value) {
        villageMapCode = new FixedLengthField(2, value);
    }
}
