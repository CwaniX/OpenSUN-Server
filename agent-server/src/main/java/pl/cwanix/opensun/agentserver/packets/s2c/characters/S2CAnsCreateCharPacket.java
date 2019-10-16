package pl.cwanix.opensun.agentserver.packets.s2c.characters;

import org.apache.commons.lang3.ArrayUtils;
import pl.cwanix.opensun.agentserver.entities.CharacterEntity;
import pl.cwanix.opensun.agentserver.packets.structures.ClientCharacterPartPacketStructure;
import pl.cwanix.opensun.commonserver.packets.Packet;
import pl.cwanix.opensun.commonserver.packets.PacketCategory;
import pl.cwanix.opensun.commonserver.packets.annotations.OutgoingPacket;

@OutgoingPacket(category = PacketCategory.CHARACTER, type = (byte) 0xE2)
public class S2CAnsCreateCharPacket implements Packet {

	private ClientCharacterPartPacketStructure character;
	
	public S2CAnsCreateCharPacket(CharacterEntity characterEntity) {
		this.character = new ClientCharacterPartPacketStructure(characterEntity);
	}
	
	@Override
	public Object[] getOrderedFields() {
		return ArrayUtils.toArray(character);
	}
}
