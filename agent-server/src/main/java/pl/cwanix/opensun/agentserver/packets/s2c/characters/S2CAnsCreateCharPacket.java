package pl.cwanix.opensun.agentserver.packets.s2c.characters;

import org.apache.commons.lang3.ArrayUtils;
import pl.cwanix.opensun.commonserver.packets.annotations.PacketOPCode;
import pl.cwanix.opensun.model.character.CharacterModel;
import pl.cwanix.opensun.agentserver.packets.structures.ClientCharacterPartPacketStructure;
import pl.cwanix.opensun.commonserver.packets.Packet;
import pl.cwanix.opensun.commonserver.packets.PacketCategory;
import pl.cwanix.opensun.commonserver.packets.annotations.OutgoingPacket;

@OutgoingPacket(category = PacketCategory.CHARACTER, operation = PacketOPCode.CHARACTER_ANS_CREATE_CHAR)
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
