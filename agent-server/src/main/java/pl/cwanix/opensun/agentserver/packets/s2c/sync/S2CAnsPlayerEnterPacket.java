package pl.cwanix.opensun.agentserver.packets.s2c.sync;

import org.apache.commons.lang3.ArrayUtils;

import io.netty.channel.ChannelHandlerContext;
import pl.cwanix.opensun.agentserver.entities.CharacterEntity;
import pl.cwanix.opensun.agentserver.server.AgentServerChannelHandler;
import pl.cwanix.opensun.agentserver.server.session.AgentServerSession;
import pl.cwanix.opensun.commonserver.packets.OutgoingPacket;
import pl.cwanix.opensun.commonserver.packets.Packet;
import pl.cwanix.opensun.commonserver.packets.PacketCategory;
import pl.cwanix.opensun.utils.datatypes.FixedLengthField;
import pl.cwanix.opensun.utils.datatypes.Vector;

@OutgoingPacket(category = PacketCategory.SYNC, type = (byte) 0x1F)
public class S2CAnsPlayerEnterPacket implements Packet {
	
	private Vector currentPosition;
	private FixedLengthField unknown;
	
	public S2CAnsPlayerEnterPacket() {
		currentPosition = new Vector();
		unknown = new FixedLengthField(2);
	}

	@Override
	public void process(ChannelHandlerContext ctx) {
		AgentServerSession session = ctx.channel().attr(AgentServerChannelHandler.SESSION_ATTRIBUTE).get();
		
		CharacterEntity character = session.getCharacter();
		
		currentPosition.setX(character.getPosition().getLocationX());
		currentPosition.setY(character.getPosition().getLocationY());
		currentPosition.setZ(character.getPosition().getLocationZ());
	}

	@Override
	public Object[] getOrderedFields() {
		return ArrayUtils.toArray(currentPosition, unknown);
	}
}
