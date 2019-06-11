package pl.cwanix.opensun.agentserver.packets.structures;

import lombok.Getter;
import lombok.Setter;
import pl.cwanix.opensun.agentserver.entities.CharacterEntity;
import pl.cwanix.opensun.commonserver.packets.PacketStructure;
import pl.cwanix.opensun.utils.bytes.BytesUtils;
import pl.cwanix.opensun.utils.packets.FixedLengthField;

@Getter
@Setter
public class ServerCharacterPartPacketStructure implements PacketStructure {
	
	private FixedLengthField charId; //4
	private FixedLengthField slot; //1
	private FixedLengthField charName; //16
	private FixedLengthField heightCode; //1
	private FixedLengthField faceCode; //1
	private FixedLengthField hairCode; //1
	private FixedLengthField classCode; //1
	private FixedLengthField level; //2
	private FixedLengthField region; //4
	private FixedLengthField x; //2
	private FixedLengthField y; //2
	private FixedLengthField z; //2
	private FixedLengthField guildId; //4
	private FixedLengthField guildPosition; //4
	private FixedLengthField guildName; //16
	private FixedLengthField playerKey; //4
	private FixedLengthField team; //1
	//private EquipItemInfoPacketStructure equipItemInfo;
	private byte[] equipItemInfo;
	
	public ServerCharacterPartPacketStructure(CharacterEntity character) {
		charId = new FixedLengthField(1, character.getId()); //!!
		slot = new FixedLengthField(1, character.getSlot());
		charName = new FixedLengthField(16, character.getName());
		heightCode = new FixedLengthField(1, character.getHeightCode());
		faceCode = new FixedLengthField(1, character.getFaceCode());
		hairCode = new FixedLengthField(1, character.getHairCode());
		classCode = new FixedLengthField(1, character.getClassCode());
		level = new FixedLengthField(2, character.getLevel());
		region = new FixedLengthField(4, 10001);
		x = new FixedLengthField(2, 0);
		y = new FixedLengthField(2, 0);
		z = new FixedLengthField(2, 0);
		guildId = new FixedLengthField(4);
		guildPosition = new FixedLengthField(4);
		guildName = new FixedLengthField(16);
		playerKey = new FixedLengthField(4);
		team = new FixedLengthField(1);
		//equipItemInfo = new EquipItemInfoPacketStructure(character.getInventory().getEquipItem());
		equipItemInfo = character.getInventory().getEquipItem();
	}

	@Override
	public byte[] toByteArray() {
		return BytesUtils.mergeArrays(
				charId.getValue(),
				slot.getValue(),
				new byte[] { 0x10 },
				charName.getValue(),
				heightCode.getValue(),
				faceCode.getValue(),
				hairCode.getValue(),
				classCode.getValue(),
				level.getValue(),
				region.getValue(),
				x.getValue(),
				y.getValue(),
				z.getValue()
				//guildId.getValue(),
				//guildPosition.getValue(),
				//guildName.getValue(),
				//playerKey.getValue(),
				//team.getValue(),
				//equipItemInfo.toByteArray()
				//equipItemInfo
				
			);
	}
}
