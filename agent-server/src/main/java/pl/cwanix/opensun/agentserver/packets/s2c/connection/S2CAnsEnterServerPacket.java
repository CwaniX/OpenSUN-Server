package pl.cwanix.opensun.agentserver.packets.s2c.connection;

import org.apache.commons.lang3.ArrayUtils;
import pl.cwanix.opensun.domain.CharacterDTO;
import pl.cwanix.opensun.agentserver.packets.structures.ClientCharacterPartPacketStructure;
import pl.cwanix.opensun.commonserver.packets.Packet;
import pl.cwanix.opensun.commonserver.packets.PacketCategory;
import pl.cwanix.opensun.commonserver.packets.annotations.OutgoingPacket;
import pl.cwanix.opensun.utils.datatypes.FixedLengthField;

import java.util.List;
import java.util.stream.Collectors;

@SuppressWarnings("checkstyle:MagicNumber")
@OutgoingPacket(category = PacketCategory.CONNECTION, type = (byte) 0x98)
public class S2CAnsEnterServerPacket implements Packet {

    private final FixedLengthField userId;
    private final FixedLengthField charCount;
    private final FixedLengthField unknown;
    private final List<ClientCharacterPartPacketStructure> charactersList;

    public S2CAnsEnterServerPacket(final int userId, final List<CharacterDTO> characterDTOList) {
        this.userId = new FixedLengthField(4, userId);
        this.charCount = new FixedLengthField(1, characterDTOList.size());
        this.unknown = new FixedLengthField(1, characterDTOList.size()); //TODO: ???
        this.charactersList = convertCharacterEntityListToClientCharacterPartPacketStructureList(characterDTOList);
    }

    private List<ClientCharacterPartPacketStructure> convertCharacterEntityListToClientCharacterPartPacketStructureList(final List<CharacterDTO> characterDTOList) {
        return characterDTOList
                .stream()
                .map(ClientCharacterPartPacketStructure::new)
                .collect(Collectors.toList());
    }

    @Override
    public Object[] getOrderedFields() {
        return ArrayUtils.toArray(userId, charCount, unknown, charactersList);
    }
}
