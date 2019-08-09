package pl.cwanix.opensun.agentserver.packets.s2c.characters;

import org.apache.commons.lang3.ArrayUtils;

import io.netty.channel.ChannelHandlerContext;
import pl.cwanix.opensun.agentserver.entities.CharacterEntity;
import pl.cwanix.opensun.agentserver.packets.structures.ClientCharacterPartPacketStructure;
import pl.cwanix.opensun.agentserver.server.AgentServerChannelHandler;
import pl.cwanix.opensun.agentserver.server.context.AgentServerContext;
import pl.cwanix.opensun.agentserver.server.session.AgentServerSession;
import pl.cwanix.opensun.commonserver.packets.OutgoingPacket;
import pl.cwanix.opensun.commonserver.packets.Packet;
import pl.cwanix.opensun.commonserver.packets.PacketCategory;

@OutgoingPacket(category = PacketCategory.CHAR_INFO, type = (byte) 0xE2)
public class S2CAnsCreateCharPacket implements Packet<AgentServerContext> {
	
	private final int slot;
	
	private ClientCharacterPartPacketStructure character;
	
	public S2CAnsCreateCharPacket(int slot) {
		this.slot = slot;
	}

	@Override
	public void process(ChannelHandlerContext ctx, AgentServerContext srv) {
		AgentServerSession session = ctx.channel().attr(AgentServerChannelHandler.SESSION_ATTRIBUTE).get();
		
		srv.getDbConnector().findCharacter(session.getUser().getAccount().getId(), slot);
		CharacterEntity characterEntity = srv.getDbConnector().findCharacter(session.getUser().getAccount().getId(), slot);
		character = new ClientCharacterPartPacketStructure(characterEntity);
	}
	
	@Override
	public Object[] getOrderedFields() {
		return ArrayUtils.toArray(character);
	}
}
