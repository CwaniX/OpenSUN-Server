package pl.cwanix.opensun.agentserver.packets.s2c.characters;

import pl.cwanix.opensun.commonserver.packets.OutgoingPacket;
import pl.cwanix.opensun.commonserver.packets.Packet;
import pl.cwanix.opensun.commonserver.packets.PacketCategory;
import pl.cwanix.opensun.utils.datatypes.FixedLengthField;

@OutgoingPacket(category = PacketCategory.CHAR_INFO, type = (byte) 0x9F)
public class S2CAnsSkillsPacket implements Packet {
	
	private FixedLengthField value;
	
	public S2CAnsSkillsPacket() {
		value = new FixedLengthField(4, new byte[] { 0x01, 0x00, (byte) 0xe1, 0x2e });
	}

}
