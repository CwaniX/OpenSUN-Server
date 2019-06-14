package pl.cwanix.opensun.agentserver.packets.c2s;

import java.util.Arrays;

import org.slf4j.Marker;
import org.slf4j.MarkerFactory;
import org.springframework.web.client.RestTemplate;

import io.netty.channel.ChannelHandlerContext;
import lombok.extern.slf4j.Slf4j;
import pl.cwanix.opensun.agentserver.packets.s2c.S2CAnsDeleteCharPacket;
import pl.cwanix.opensun.agentserver.properties.AgentServerProperties;
import pl.cwanix.opensun.agentserver.server.AgentServerChannelHandler;
import pl.cwanix.opensun.agentserver.server.session.AgentServerSession;
import pl.cwanix.opensun.commonserver.packets.ClientPacket;
import pl.cwanix.opensun.utils.packets.FixedLengthField;
import pl.cwanix.opensun.utils.packets.PacketHeader;

@Slf4j
public class C2SAskDeleteCharPacket extends ClientPacket {
	
	private static final Marker MARKER = MarkerFactory.getMarker("C2S -> DELETE CHAR");
	
	private static final String DELETE_WORD = "delete";
	
	public static final PacketHeader PACKET_ID = new PacketHeader((byte) 0xA5, (byte) 0x89);
	
	private FixedLengthField slotNumber;
	private FixedLengthField deleteWord;
	
	public C2SAskDeleteCharPacket(byte[] value) {
		this.slotNumber = new FixedLengthField(1, value[0]);
		this.deleteWord = new FixedLengthField(10, Arrays.copyOfRange(value, 1, value.length));
	}

	@Override
	public void process(ChannelHandlerContext ctx) {
		AgentServerSession session = ctx.channel().attr(AgentServerChannelHandler.SESSION_ATTRIBUTE).get();
		RestTemplate restTemplate = ctx.channel().attr(AgentServerChannelHandler.REST_TEMPLATE_ATTRIBUTE).get();
		AgentServerProperties properties = ctx.channel().attr(AgentServerChannelHandler.PROPERIES_ATTRIBUTE).get();
		S2CAnsDeleteCharPacket ansDeleteCharPacket = new S2CAnsDeleteCharPacket();
		
		if (DELETE_WORD.equals(deleteWord.toString())) {
			log.info(MARKER, "Deletig character");
			restTemplate.delete(properties.getDb().getServerUrl() + "/character/delete?accountId=" + session.getUser().getAccount().getId() + "&slot=" + slotNumber.getValue()[0]);
		} else {
			log.info(MARKER, "Unable to delete character");
		}
		
		ctx.writeAndFlush(ansDeleteCharPacket);
	}

}
