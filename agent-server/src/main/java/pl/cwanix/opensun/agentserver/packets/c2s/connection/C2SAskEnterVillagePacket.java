package pl.cwanix.opensun.agentserver.packets.c2s.connection;

import lombok.Getter;
import pl.cwanix.opensun.agentserver.packets.AgentServerPacketOPCode;
import pl.cwanix.opensun.commonserver.packets.Packet;
import pl.cwanix.opensun.commonserver.packets.annotations.IncomingPacket;
import pl.cwanix.opensun.utils.datatypes.FixedLengthField;

@SuppressWarnings("checkstyle:MagicNumber")
@Getter
@IncomingPacket(category = AgentServerPacketOPCode.Connection.CATEGORY, operation = AgentServerPacketOPCode.Connection.Ask.ENTER_VILLAGE)
public class C2SAskEnterVillagePacket implements Packet {

    private final FixedLengthField selectedChar;

    public C2SAskEnterVillagePacket(final byte[] value) {
        selectedChar = new FixedLengthField(1, value[0]);
    }
}
