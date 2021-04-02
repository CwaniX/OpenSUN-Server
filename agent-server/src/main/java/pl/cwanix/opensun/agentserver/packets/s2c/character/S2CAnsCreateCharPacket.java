package pl.cwanix.opensun.agentserver.packets.s2c.character;

import org.apache.commons.lang3.ArrayUtils;
import pl.cwanix.opensun.agentserver.packets.AgentServerPacketOPCode;
import pl.cwanix.opensun.model.character.CharacterModel;
import pl.cwanix.opensun.agentserver.packets.structures.ClientCharacterPartPacketStructure;
import pl.cwanix.opensun.commonserver.packets.Packet;
import pl.cwanix.opensun.commonserver.packets.annotations.OutgoingPacket;

@OutgoingPacket(category = AgentServerPacketOPCode.Character.CATEGORY, operation = AgentServerPacketOPCode.Character.Ans.CREATE_CHAR)
public class S2CAnsCreateCharPacket implements Packet {

    private final ClientCharacterPartPacketStructure character;

    public S2CAnsCreateCharPacket(final CharacterModel characterModel) {
        this.character = new ClientCharacterPartPacketStructure(characterModel);
    }

    @Override
    public Object[] getOrderedFields() {
        return ArrayUtils.toArray(character);
    }
}
