package pl.cwanix.opensun.agentserver.packets.c2s;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Marker;
import org.slf4j.MarkerFactory;
import org.springframework.web.client.RestTemplate;

import io.netty.channel.ChannelHandlerContext;
import lombok.extern.slf4j.Slf4j;
import pl.cwanix.opensun.agentserver.entities.CharacterEntity;
import pl.cwanix.opensun.agentserver.packets.s2c.S2CAnsCreateNewCharPacket;
import pl.cwanix.opensun.agentserver.properties.AgentServerProperties;
import pl.cwanix.opensun.agentserver.server.AgentServerChannelHandler;
import pl.cwanix.opensun.agentserver.server.session.AgentServerSession;
import pl.cwanix.opensun.commonserver.packets.ClientPacket;
import pl.cwanix.opensun.utils.packets.FixedLengthField;
import pl.cwanix.opensun.utils.packets.PacketHeader;

@Slf4j
public class C2SAskCreateNewCharPacket extends ClientPacket {
	
	private static final Marker MARKER = MarkerFactory.getMarker("C2S -> CREATE NEW CHAR");
	
	public static final PacketHeader PACKET_ID = new PacketHeader((byte) 0xA5, (byte) 0x6F);

	private FixedLengthField classCode;
	private FixedLengthField charName;
	private FixedLengthField heightCode;
	private FixedLengthField faceCode;
	private FixedLengthField hairCode;

	public C2SAskCreateNewCharPacket(byte[] value) {
		this.classCode = new FixedLengthField(1, value[15]);
		this.charName = new FixedLengthField(16, Arrays.copyOfRange(value, 20, 37));
		this.heightCode = new FixedLengthField(1, value[37]);
		this.faceCode = new FixedLengthField(1, value[38]);
		this.hairCode = new FixedLengthField(1, value[39]);
	}

	@Override
	public void process(ChannelHandlerContext ctx) {
		AgentServerSession session = ctx.channel().attr(AgentServerChannelHandler.SESSION_ATTRIBUTE).get();
		RestTemplate restTemplate = ctx.channel().attr(AgentServerChannelHandler.REST_TEMPLATE_ATTRIBUTE).get();
		AgentServerProperties properties = ctx.channel().attr(AgentServerChannelHandler.PROPERIES_ATTRIBUTE).get();

		log.info(MARKER, "Creating new character");
		
		int slot = findFreeSlot(session.getUser().getAccount().getCharacters());
		
		if (slot > -1) {
			restTemplate.postForObject("http://" + properties.getDb().getIp() + ":" + properties.getDb().getPort()
					+ "/character/create?accountId=" + session.getUser().getAccount().getId()
					+ "&name=" + charName.toString()
					+ "&classCode=" + classCode.getValue()[0]
					+ "&heightCode=" + heightCode.getValue()[0]
					+ "&faceCode=" + faceCode.getValue()[0]
					+ "&hairCode=" + hairCode.getValue()[0]
					+ "&slot=" + slot,
					null, Integer.class);
			
			S2CAnsCreateNewCharPacket ansCreateNewCharPackiet = new S2CAnsCreateNewCharPacket(slot);
			ansCreateNewCharPackiet.process(ctx);
			
			ctx.writeAndFlush(ansCreateNewCharPackiet);
		}
	}

	private int findFreeSlot(List<CharacterEntity> characters) {
		/*List<Integer> slots = characters.stream().map(CharacterEntity::getSlot).collect(Collectors.toList());
		
		for (int i = 0; i < 5; i++) {
			if (!slots.contains(i)) {
				return i;
			}
		}*/
		
		return 1;
	}
}
