package pl.cwanix.opensun.agentserver.packets.structures;

import lombok.Getter;
import lombok.Setter;
import pl.cwanix.opensun.commonserver.packets.PacketStructure;
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
	private EquipItemInfoPacketStructure equipItemInfo;

	@Override
	public byte[] toByteArray() {
		// TODO Auto-generated method stub
		return null;
	}
}
