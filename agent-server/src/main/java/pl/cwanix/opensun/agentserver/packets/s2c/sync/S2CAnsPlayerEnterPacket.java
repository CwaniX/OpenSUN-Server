package pl.cwanix.opensun.agentserver.packets.s2c.sync;

import org.apache.commons.lang3.ArrayUtils;
import pl.cwanix.opensun.agentserver.entities.CharacterEntity;
import pl.cwanix.opensun.commonserver.packets.Packet;
import pl.cwanix.opensun.commonserver.packets.PacketCategory;
import pl.cwanix.opensun.commonserver.packets.annotations.OutgoingPacket;
import pl.cwanix.opensun.utils.datatypes.FixedLengthField;
import pl.cwanix.opensun.utils.datatypes.Vector;

@OutgoingPacket(category = PacketCategory.SYNC, type = (byte) 0x1F)
public class S2CAnsPlayerEnterPacket implements Packet {
	
	private Vector currentPosition;
	private FixedLengthField unknown;
	
	public S2CAnsPlayerEnterPacket(CharacterEntity character) {
		currentPosition = new Vector(character.getPosition().getLocationX(), character.getPosition().getLocationY(), character.getPosition().getLocationZ());
		unknown = new FixedLengthField(2);
	}

	@Override
	public Object[] getOrderedFields() {
		return ArrayUtils.toArray(currentPosition, unknown);
	}
}
