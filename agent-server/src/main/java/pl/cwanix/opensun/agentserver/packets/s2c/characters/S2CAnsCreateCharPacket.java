package pl.cwanix.opensun.agentserver.packets.s2c.characters;

import org.springframework.web.client.RestTemplate;

import io.netty.channel.ChannelHandlerContext;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import pl.cwanix.opensun.agentserver.entities.CharacterEntity;
import pl.cwanix.opensun.agentserver.packets.structures.ClientCharacterPartPacketStructure;
import pl.cwanix.opensun.agentserver.properties.AgentServerProperties;
import pl.cwanix.opensun.agentserver.server.AgentServerChannelHandler;
import pl.cwanix.opensun.agentserver.server.session.AgentServerSession;
import pl.cwanix.opensun.commonserver.packets.OutgoingPacket;
import pl.cwanix.opensun.commonserver.packets.Packet;
import pl.cwanix.opensun.utils.packets.PacketHeader;

@Slf4j
@Getter
@OutgoingPacket
public class S2CAnsCreateCharPacket extends Packet {
	
	public static final PacketHeader PACKET_ID = new PacketHeader((byte) 0xA5, (byte) 0xE2);
	
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

}
