package pl.cwanix.opensun.agentserver.packets.s2c;

import org.springframework.web.client.RestTemplate;

import io.netty.channel.ChannelHandlerContext;
import pl.cwanix.opensun.agentserver.entities.CharacterEntity;
import pl.cwanix.opensun.agentserver.packets.structures.ServerCharacterPartPacketStructure;
import pl.cwanix.opensun.agentserver.properties.AgentServerProperties;
import pl.cwanix.opensun.agentserver.server.AgentServerChannelHandler;
import pl.cwanix.opensun.agentserver.server.session.AgentServerSession;
import pl.cwanix.opensun.commonserver.packets.ServerPacket;
import pl.cwanix.opensun.utils.bytes.BytesUtils;
import pl.cwanix.opensun.utils.packets.PacketHeader;

public class S2CAnsCreateNewCharPacket extends ServerPacket {
	
	public static final PacketHeader PACKET_ID = new PacketHeader((byte) 0xA5, (byte) 0xE2);
	
	private final int slot;
	private ServerCharacterPartPacketStructure character;
	
	public S2CAnsCreateNewCharPacket(int slot) {
		this.slot = slot;
	}

	@Override
	public byte[] toByteArray() {
		return BytesUtils.mergeArrays(PACKET_ID.getValue(), character.toByteArray());
	}

	@Override
	public void process(ChannelHandlerContext ctx) {
		AgentServerSession session = ctx.channel().attr(AgentServerChannelHandler.SESSION_ATTRIBUTE).get();
		RestTemplate restTemplate = ctx.channel().attr(AgentServerChannelHandler.REST_TEMPLATE_ATTRIBUTE).get();
		AgentServerProperties properties = ctx.channel().attr(AgentServerChannelHandler.PROPERIES_ATTRIBUTE).get();
		
		CharacterEntity characterEntity = restTemplate.getForObject("http://" + properties.getDb().getIp() + ":" + properties.getDb().getPort() + "/character/findByAccountAndSlot?accountId=" + session.getUser().getAccount().getId() + "&slot=" + slot, CharacterEntity.class);
		character = new ServerCharacterPartPacketStructure(characterEntity);
	}

}
