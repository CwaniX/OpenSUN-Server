package pl.cwanix.opensun.agentserver.packets.s2c.sync;

import org.apache.commons.lang3.ArrayUtils;
import pl.cwanix.opensun.agentserver.packets.AgentServerPacketOPCode;
import pl.cwanix.opensun.model.character.CharacterModel;
import pl.cwanix.opensun.commonserver.packets.Packet;
import pl.cwanix.opensun.commonserver.packets.annotations.OutgoingPacket;
import pl.cwanix.opensun.utils.datatypes.FixedLengthField;
import pl.cwanix.opensun.utils.datatypes.Vector;

@SuppressWarnings("checkstyle:MagicNumber")
@OutgoingPacket(category = AgentServerPacketOPCode.Sync.CATEGORY, operation = AgentServerPacketOPCode.Sync.Ans.PLAYER_ENTER)
public class S2CAnsPlayerEnterPacket implements Packet {

    private final Vector currentPosition;
    private final FixedLengthField unknown;

    public S2CAnsPlayerEnterPacket(final CharacterModel character) {
        currentPosition = new Vector(character.getPosition().getLocationX(), character.getPosition().getLocationY(), character.getPosition().getLocationZ());
        unknown = new FixedLengthField(2);
    }

    @Override
    public Object[] getOrderedFields() {
        return ArrayUtils.toArray(currentPosition, unknown);
    }
}
