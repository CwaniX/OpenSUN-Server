package pl.cwanix.opensun.agentserver.packets.s2c.connection;

import org.apache.commons.lang3.ArrayUtils;
import pl.cwanix.opensun.agentserver.packets.AgentServerPacketOPCode;
import pl.cwanix.opensun.model.character.CharacterModel;
import pl.cwanix.opensun.agentserver.packets.structures.ClientCharacterPartPacketStructure;
import pl.cwanix.opensun.commonserver.packets.Packet;
import pl.cwanix.opensun.commonserver.packets.annotations.OutgoingPacket;
import pl.cwanix.opensun.utils.datatypes.FixedLengthField;

import java.util.List;
import java.util.stream.Collectors;

@SuppressWarnings("checkstyle:MagicNumber")
@OutgoingPacket(category = AgentServerPacketOPCode.Connection.CATEGORY, operation = AgentServerPacketOPCode.Connection.Ans.ENTER_SERVER)
public class S2CAnsEnterServerPacket implements Packet {

    private final FixedLengthField userId;
    private final FixedLengthField charCount;
    private final FixedLengthField unknown;
    private final List<ClientCharacterPartPacketStructure> charactersList;

    public S2CAnsEnterServerPacket(final int userId, final List<CharacterModel> characterModelList) {
        this.userId = new FixedLengthField(4, userId);
        this.charCount = new FixedLengthField(1, characterModelList.size());
        this.unknown = new FixedLengthField(1, characterModelList.size()); //TODO: ???
        this.charactersList = convertCharacterEntityListToClientCharacterPartPacketStructureList(characterModelList);
    }

    private List<ClientCharacterPartPacketStructure> convertCharacterEntityListToClientCharacterPartPacketStructureList(final List<CharacterModel> characterModelList) {
        return characterModelList
                .stream()
                .map(ClientCharacterPartPacketStructure::new)
                .collect(Collectors.toList());
    }

    @Override
    public Object[] getOrderedFields() {
        return ArrayUtils.toArray(userId, charCount, unknown, charactersList);
    }
}
