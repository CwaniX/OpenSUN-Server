package pl.cwanix.opensun.agentserver.packets.s2c;

import org.springframework.web.client.RestTemplate;

import io.netty.channel.ChannelHandlerContext;
import lombok.Getter;
import lombok.Setter;
import pl.cwanix.opensun.agentserver.entities.CharacterEntityList;
import pl.cwanix.opensun.agentserver.packets.structures.ServerCharacterPartPacketStructure;
import pl.cwanix.opensun.agentserver.properties.AgentServerProperties;
import pl.cwanix.opensun.agentserver.server.AgentServerChannelHandler;
import pl.cwanix.opensun.agentserver.server.session.AgentServerSession;
import pl.cwanix.opensun.commonserver.packets.ServerPacket;
import pl.cwanix.opensun.utils.bytes.BytesUtils;
import pl.cwanix.opensun.utils.packets.FixedLengthField;
import pl.cwanix.opensun.utils.packets.PacketHeader;

@Getter
@Setter
public class S2CAnsCharListPacket extends ServerPacket {

	public static final PacketHeader PACKET_ID = new PacketHeader((byte) 0x48, (byte) 0x98);

	private FixedLengthField userId;
	private FixedLengthField charCount;
	private ServerCharacterPartPacketStructure characterList;

	public S2CAnsCharListPacket() {
		userId = new FixedLengthField(4);
		charCount = new FixedLengthField(1);
		
	}
	
	@Override
	public void process(ChannelHandlerContext ctx) {
		AgentServerSession session = ctx.channel().attr(AgentServerChannelHandler.SESSION_ATTRIBUTE).get();
		RestTemplate restTemplate = ctx.channel().attr(AgentServerChannelHandler.REST_TEMPLATE_ATTRIBUTE).get();
		AgentServerProperties properties = ctx.channel().attr(AgentServerChannelHandler.PROPERIES_ATTRIBUTE).get();
		
		CharacterEntityList characters = restTemplate.getForObject("http://" + properties.getDb().getIp() + ":" + properties.getDb().getPort() + "/character/findByAccount?accountId=" + session.getUser().getAccount().getId(), CharacterEntityList.class);
		userId.setValue(session.getUser().getId());
		charCount.setValue((byte) characters.getList().size());
	}

	@Override
	public byte[] toByteArray() {
		return BytesUtils.mergeArrays(PACKET_ID.getValue());
	}
}
