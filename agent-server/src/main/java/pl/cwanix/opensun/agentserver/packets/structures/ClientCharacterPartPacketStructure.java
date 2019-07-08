package pl.cwanix.opensun.agentserver.packets.structures;

import org.apache.commons.lang3.ArrayUtils;

import pl.cwanix.opensun.agentserver.entities.CharacterEntity;
import pl.cwanix.opensun.commonserver.packets.PacketStructure;
import pl.cwanix.opensun.utils.datatypes.FixedLengthField;

public class ClientCharacterPartPacketStructure implements PacketStructure {

	private FixedLengthField slot;
	private FixedLengthField size;
	private FixedLengthField charName;
	private FixedLengthField heightCode;
	private FixedLengthField faceCode;
	private FixedLengthField hairCode;
	private FixedLengthField classCode;
	private FixedLengthField level;
	private FixedLengthField region;
	private FixedLengthField x;
	private FixedLengthField y;
	private FixedLengthField z;
	private FixedLengthField equipNumber;
	private EquipItemInfoPacketStructure equipItemInfo;
	private FixedLengthField unknown1;
	private FixedLengthField unknown2;
	private FixedLengthField unknown3;
	private FixedLengthField unknown4;

	public ClientCharacterPartPacketStructure(CharacterEntity character) {
		slot = new FixedLengthField(1, character.getSlot());
		size = new FixedLengthField(1, 0x10);
		charName = new FixedLengthField(16, character.getName());
		heightCode = new FixedLengthField(1, character.getHeightCode());
		faceCode = new FixedLengthField(1, character.getFaceCode());
		hairCode = new FixedLengthField(1, character.getHairCode());
		classCode = new FixedLengthField(1, character.getClassCode());
		level = new FixedLengthField(2, character.getLevel());
		region = new FixedLengthField(4, character.getPosition().getRegion());
		x = new FixedLengthField(2, character.getPosition().getLocationX());
		y = new FixedLengthField(2, character.getPosition().getLocationY());
		z = new FixedLengthField(2, character.getPosition().getLocationZ());
		equipNumber = new FixedLengthField(1, 0);
		equipItemInfo = new EquipItemInfoPacketStructure(character.getInventory().getEquipItem());
		unknown1 = new FixedLengthField(1);
		unknown2 = new FixedLengthField(32);
		unknown3 = new FixedLengthField(3);
		unknown4 = new FixedLengthField(4);
	}

	@Override
	public Object[] getOrderedFields() {
		return ArrayUtils.toArray(slot, size, charName, heightCode, faceCode, hairCode, classCode, level, region, x, y,
				z, equipNumber, equipItemInfo, unknown1, unknown2, unknown3, unknown4);
	}
}
