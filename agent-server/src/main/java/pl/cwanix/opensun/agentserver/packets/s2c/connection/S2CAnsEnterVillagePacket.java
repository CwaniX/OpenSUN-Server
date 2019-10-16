package pl.cwanix.opensun.agentserver.packets.s2c.connection;

import org.apache.commons.lang3.ArrayUtils;
import pl.cwanix.opensun.commonserver.packets.Packet;
import pl.cwanix.opensun.commonserver.packets.PacketCategory;
import pl.cwanix.opensun.commonserver.packets.annotations.OutgoingPacket;
import pl.cwanix.opensun.utils.datatypes.FixedLengthField;

@OutgoingPacket(category = PacketCategory.CONNECTION, type = (byte) 0x83)
public class S2CAnsEnterVillagePacket implements Packet {
	
	private FixedLengthField playerKey;
	
	public S2CAnsEnterVillagePacket(int playerKey) {
		this.playerKey = new FixedLengthField(4, playerKey);
	}
	
	@Override
	public Object[] getOrderedFields() {
		return ArrayUtils.toArray(playerKey);
	}
}
