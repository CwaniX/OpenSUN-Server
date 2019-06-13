package pl.cwanix.opensun.agentserver.packets.structures;

import pl.cwanix.opensun.agentserver.entities.CharacterEntity;
import pl.cwanix.opensun.commonserver.packets.PacketStructure;
import pl.cwanix.opensun.utils.bytes.BytesUtils;
import pl.cwanix.opensun.utils.packets.FixedLengthField;

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
	private FixedLengthField unknownField1;
	private FixedLengthField unknownField2;
	private FixedLengthField unknownField3;
	private FixedLengthField unknownField4;
	
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
		equipNumber = new FixedLengthField(1);
		equipItemInfo = new EquipItemInfoPacketStructure(character.getInventory().getEquipItem());
		unknownField1 = new FixedLengthField(1);
		unknownField2 = new FixedLengthField(32);
		unknownField3 = new FixedLengthField(3);
		unknownField4 = new FixedLengthField(4);
	}

	@Override
	public byte[] toByteArray() {
		return BytesUtils.mergeArrays(
				slot.getValue(),
				size.getValue(),
				charName.getValue(),
				heightCode.getValue(),
				faceCode.getValue(),
				hairCode.getValue(),
				classCode.getValue(),
				level.getValue(),
				region.getValue(),
				equipNumber.getValue(),
				x.getValue(),
				y.getValue(),
				z.getValue(),
				equipItemInfo.toByteArray(),
				unknownField1.getValue(),
				unknownField2.getValue(),
				unknownField3.getValue(),
				unknownField4.getValue()
			);
	}
}
