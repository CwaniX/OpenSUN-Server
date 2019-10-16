package pl.cwanix.opensun.agentserver.packets.s2c.connection;

import org.apache.commons.lang3.ArrayUtils;
import pl.cwanix.opensun.agentserver.entities.CharacterEntity;
import pl.cwanix.opensun.agentserver.packets.structures.ClientCharacterPartPacketStructure;
import pl.cwanix.opensun.commonserver.packets.Packet;
import pl.cwanix.opensun.commonserver.packets.PacketCategory;
import pl.cwanix.opensun.commonserver.packets.annotations.OutgoingPacket;
import pl.cwanix.opensun.utils.datatypes.FixedLengthField;

import java.util.List;
import java.util.stream.Collectors;

@OutgoingPacket(category = PacketCategory.CONNECTION, type = (byte) 0x98)
public class S2CAnsEnterServerPacket implements Packet {

	private FixedLengthField userId;
	private FixedLengthField charCount;
	private FixedLengthField unknown;
	private List<ClientCharacterPartPacketStructure> charactersList;

	public S2CAnsEnterServerPacket(int userId, List<CharacterEntity> characterEntityList) {
		this.userId = new FixedLengthField(4, userId);
		this.charCount = new FixedLengthField(1, characterEntityList.size());
		this.unknown = new FixedLengthField(1, characterEntityList.size()); //TODO: ???
		this.charactersList = convertCharacterEntityListToClientCharacterPartPacketStructureList(characterEntityList);
	}

	private List<ClientCharacterPartPacketStructure> convertCharacterEntityListToClientCharacterPartPacketStructureList(List<CharacterEntity> characterEntityList) {
		return characterEntityList
				.stream()
				.map(character -> new ClientCharacterPartPacketStructure(character))
				.collect(Collectors.toList());
	}
	
	@Override
	public Object[] getOrderedFields() {
		return ArrayUtils.toArray(userId, charCount, unknown, charactersList);
	}
}
