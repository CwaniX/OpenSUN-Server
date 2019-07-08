package pl.cwanix.opensun.agentserver.packets.s2c.characters;

import org.apache.commons.lang3.ArrayUtils;
import org.springframework.web.client.RestTemplate;

import io.netty.channel.ChannelHandlerContext;
import pl.cwanix.opensun.agentserver.entities.CharacterEntity;
import pl.cwanix.opensun.agentserver.packets.structures.ClientCharacterPartPacketStructure;
import pl.cwanix.opensun.agentserver.properties.AgentServerProperties;
import pl.cwanix.opensun.agentserver.server.AgentServerChannelHandler;
import pl.cwanix.opensun.agentserver.server.session.AgentServerSession;
import pl.cwanix.opensun.commonserver.packets.OutgoingPacket;
import pl.cwanix.opensun.commonserver.packets.Packet;
import pl.cwanix.opensun.commonserver.packets.PacketCategory;

@OutgoingPacket(category = PacketCategory.CHAR_INFO, type = (byte) 0xE2)
public class S2CAnsCreateCharPacket implements Packet {
	
	private final int slot;
	
	private ClientCharacterPartPacketStructure character;
	
	public S2CAnsCreateCharPacket(int slot) {
		this.slot = slot;
	}

	@Override
	public void process(ChannelHandlerContext ctx) {
		AgentServerSession session = ctx.channel().attr(AgentServerChannelHandler.SESSION_ATTRIBUTE).get();
		RestTemplate restTemplate = ctx.channel().attr(AgentServerChannelHandler.REST_TEMPLATE_ATTRIBUTE).get();
		AgentServerProperties properties = ctx.channel().attr(AgentServerChannelHandler.PROPERIES_ATTRIBUTE).get();
		
		CharacterEntity characterEntity = restTemplate.getForObject(properties.getDb().getServerUrl() + "/character/findByAccountIdAndSlot?accountId=" + session.getUser().getAccount().getId() + "&slot=" + slot, CharacterEntity.class);
		character = new ClientCharacterPartPacketStructure(characterEntity);
	}
	
	@Override
	public Object[] getOrderedFields() {
		return ArrayUtils.toArray(character);
	}
}
