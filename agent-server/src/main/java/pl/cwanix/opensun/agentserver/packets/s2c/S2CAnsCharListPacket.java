package pl.cwanix.opensun.agentserver.packets.s2c;

import java.util.ArrayList;
import java.util.List;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.web.client.RestTemplate;

import io.netty.channel.ChannelHandlerContext;
import pl.cwanix.opensun.agentserver.entities.CharacterEntity;
import pl.cwanix.opensun.agentserver.packets.structures.ServerCharacterPartPacketStructure;
import pl.cwanix.opensun.agentserver.properties.AgentServerProperties;
import pl.cwanix.opensun.agentserver.server.AgentServerChannelHandler;
import pl.cwanix.opensun.agentserver.server.session.AgentServerSession;
import pl.cwanix.opensun.commonserver.packets.ServerPacket;
import pl.cwanix.opensun.utils.bytes.BytesUtils;
import pl.cwanix.opensun.utils.packets.FixedLengthField;
import pl.cwanix.opensun.utils.packets.PacketHeader;

public class S2CAnsCharListPacket extends ServerPacket {

	public static final PacketHeader PACKET_ID = new PacketHeader((byte) 0x48, (byte) 0x98);

	private FixedLengthField userId;
	private FixedLengthField charCount;
	private FixedLengthField unknownField1;
	private List<ServerCharacterPartPacketStructure> characterList;

	public S2CAnsCharListPacket() {
		userId = new FixedLengthField(4);
		charCount = new FixedLengthField(1);
		unknownField1 = new FixedLengthField(1);
		characterList = new ArrayList<>();
	}
	
	@Override
	public void process(ChannelHandlerContext ctx) {
		AgentServerSession session = ctx.channel().attr(AgentServerChannelHandler.SESSION_ATTRIBUTE).get();
		RestTemplate restTemplate = ctx.channel().attr(AgentServerChannelHandler.REST_TEMPLATE_ATTRIBUTE).get();
		AgentServerProperties properties = ctx.channel().attr(AgentServerChannelHandler.PROPERIES_ATTRIBUTE).get();
		
		List<CharacterEntity> characters = restTemplate.exchange("http://" + properties.getDb().getIp() + ":" + properties.getDb().getPort() + "/character/findByAccountId?accountId=" + session.getUser().getAccount().getId(), HttpMethod.GET, null, new ParameterizedTypeReference<List<CharacterEntity>>(){}).getBody();
		userId.setValue(session.getUser().getId());
		charCount.setValue((byte) characters.size());
		characters.stream().forEach(character -> characterList.add(new ServerCharacterPartPacketStructure(character)));
	}

	@Override
	public byte[] toByteArray() {		
		return BytesUtils.mergeArrays(
				PACKET_ID.getValue(),
				userId.getValue(),
				charCount.getValue(),
				unknownField1.getValue(),
				characterList.get(0) != null ? characterList.get(0).toByteArray() : null,
				characterList.get(1) != null ? characterList.get(1).toByteArray() : null,
				characterList.get(2) != null ? characterList.get(2).toByteArray() : null,
				characterList.get(3) != null ? characterList.get(3).toByteArray() : null,
				characterList.get(4) != null ? characterList.get(4).toByteArray() : null
			);
	}
}
