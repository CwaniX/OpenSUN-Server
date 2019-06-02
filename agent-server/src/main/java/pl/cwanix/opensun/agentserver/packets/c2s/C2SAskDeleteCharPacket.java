package pl.cwanix.opensun.agentserver.packets.c2s;

import java.util.Arrays;

import org.springframework.web.client.RestTemplate;

import io.netty.channel.ChannelHandlerContext;
import pl.cwanix.opensun.agentserver.packets.s2c.S2CAnsDeleteCharPacket;
import pl.cwanix.opensun.agentserver.properties.AgentServerProperties;
import pl.cwanix.opensun.agentserver.server.AgentServerChannelHandler;
import pl.cwanix.opensun.agentserver.server.session.AgentServerSession;
import pl.cwanix.opensun.commonserver.packets.ClientPacket;
import pl.cwanix.opensun.utils.packets.FixedLengthField;
import pl.cwanix.opensun.utils.packets.PacketHeader;

public class C2SAskDeleteCharPacket extends ClientPacket {
	
	private static final String DELETE_WORD = "delete";
	
	public static final PacketHeader PACKET_ID = new PacketHeader((byte) 0xA5, (byte) 0x89);
	
	private FixedLengthField slotNumber;
	private FixedLengthField deleteWord;
	
	public C2SAskDeleteCharPacket(byte[] value) {
		this.slotNumber = new FixedLengthField(1, value[0]);
		this.deleteWord = new FixedLengthField(4, Arrays.copyOfRange(value, 1, value.length));
	}

	@Override
	public void process(ChannelHandlerContext ctx) {
		AgentServerSession session = ctx.channel().attr(AgentServerChannelHandler.SESSION_ATTRIBUTE).get();
		RestTemplate restTemplate = ctx.channel().attr(AgentServerChannelHandler.REST_TEMPLATE_ATTRIBUTE).get();
		AgentServerProperties properties = ctx.channel().attr(AgentServerChannelHandler.PROPERIES_ATTRIBUTE).get();
		S2CAnsDeleteCharPacket ansDeleteCharPacket = new S2CAnsDeleteCharPacket();
		
		if (DELETE_WORD.equals(deleteWord.toString())) {
			restTemplate.delete("http://" + properties.getDb().getIp() + ":" + properties.getDb().getPort() + "/user/findByName?name=" + name.toString());
		}
		
		ctx.writeAndFlush(ansDeleteCharPacket);
	}

}
