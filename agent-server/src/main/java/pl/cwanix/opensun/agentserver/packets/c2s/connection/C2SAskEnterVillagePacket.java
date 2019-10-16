package pl.cwanix.opensun.agentserver.packets.c2s.connection;

import lombok.Getter;
import pl.cwanix.opensun.commonserver.packets.Packet;
import pl.cwanix.opensun.commonserver.packets.PacketCategory;
import pl.cwanix.opensun.commonserver.packets.annotations.IncomingPacket;
import pl.cwanix.opensun.utils.datatypes.FixedLengthField;

@Getter
@IncomingPacket(category = PacketCategory.CONNECTION, type = 0x1F)
public class C2SAskEnterVillagePacket implements Packet {
	
	private FixedLengthField selectedChar;
	
	public C2SAskEnterVillagePacket(byte[] value) {
		selectedChar = new FixedLengthField(1, value[0]);
	}
}
