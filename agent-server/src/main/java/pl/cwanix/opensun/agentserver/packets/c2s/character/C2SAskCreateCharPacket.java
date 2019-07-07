package pl.cwanix.opensun.agentserver.packets.c2s.character;

import java.util.Arrays;

import org.slf4j.Marker;
import org.slf4j.MarkerFactory;
import org.springframework.web.client.RestTemplate;

import io.netty.channel.ChannelHandlerContext;
import lombok.extern.slf4j.Slf4j;
import pl.cwanix.opensun.agentserver.packets.s2c.characters.S2CAnsCreateCharPacket;
import pl.cwanix.opensun.agentserver.properties.AgentServerProperties;
import pl.cwanix.opensun.agentserver.server.AgentServerChannelHandler;
import pl.cwanix.opensun.agentserver.server.session.AgentServerSession;
import pl.cwanix.opensun.commonserver.packets.IncomingPacket;
import pl.cwanix.opensun.commonserver.packets.Packet;
import pl.cwanix.opensun.commonserver.packets.PacketCategory;
import pl.cwanix.opensun.utils.datatypes.FixedLengthField;

@Slf4j
@IncomingPacket(category = PacketCategory.CHAR_INFO, type = 0x6F)
public class C2SAskCreateCharPacket implements Packet {
	
	private static final Marker MARKER = MarkerFactory.getMarker("C2S -> CREATE NEW CHAR");

	private FixedLengthField classCode;
	private FixedLengthField charName;
	private FixedLengthField heightCode;
	private FixedLengthField faceCode;
	private FixedLengthField hairCode;

	public C2SAskCreateCharPacket(byte[] value) {
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
		
		int slot = restTemplate.getForObject(properties.getDb().getServerUrl()
				+ "/character/findFreeSlotByAccountId?accountId="
				+ session.getUser().getAccount().getId(), Integer.class);
		
		if (slot > -1) {
			restTemplate.postForObject(properties.getDb().getServerUrl()
					+ "/character/create?accountId=" + session.getUser().getAccount().getId()
					+ "&name=" + charName.toString()
					+ "&classCode=" + classCode.toByteArray()[0]
					+ "&heightCode=" + heightCode.toByteArray()[0]
					+ "&faceCode=" + faceCode.toByteArray()[0]
					+ "&hairCode=" + hairCode.toByteArray()[0]
					+ "&slot=" + slot,
					null, Integer.class);
			
			ctx.writeAndFlush(new S2CAnsCreateCharPacket(slot));
		} else {
			log.info(MARKER, "Unable to create new character. There is not free slot!");
		}
	}
}
