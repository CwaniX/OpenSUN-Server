package pl.cwanix.opensun.agentserver.packets.s2c.characters;

import org.apache.commons.lang3.ArrayUtils;
import pl.cwanix.opensun.domain.CharacterDTO;
import pl.cwanix.opensun.agentserver.packets.structures.ClientCharacterPartPacketStructure;
import pl.cwanix.opensun.commonserver.packets.Packet;
import pl.cwanix.opensun.commonserver.packets.PacketCategory;
import pl.cwanix.opensun.commonserver.packets.annotations.OutgoingPacket;

@SuppressWarnings("checkstyle:MagicNumber")
@OutgoingPacket(category = PacketCategory.CHARACTER, type = (byte) 0xE2)
public class S2CAnsCreateCharPacket implements Packet {

    private final ClientCharacterPartPacketStructure character;

    public S2CAnsCreateCharPacket(final CharacterDTO characterDTO) {
        this.character = new ClientCharacterPartPacketStructure(characterDTO);
    }

    @Override
    public Object[] getOrderedFields() {
        return ArrayUtils.toArray(character);
    }
}
