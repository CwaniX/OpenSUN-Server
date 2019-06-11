package pl.cwanix.opensun.agentserver.packets.c2s;

import java.util.Arrays;

import org.springframework.web.client.RestTemplate;

import io.netty.channel.ChannelHandlerContext;
import pl.cwanix.opensun.agentserver.packets.s2c.S2CAnsCreateNewCharPacket;
import pl.cwanix.opensun.agentserver.properties.AgentServerProperties;
import pl.cwanix.opensun.agentserver.server.AgentServerChannelHandler;
import pl.cwanix.opensun.agentserver.server.session.AgentServerSession;
import pl.cwanix.opensun.commonserver.packets.ClientPacket;
import pl.cwanix.opensun.utils.packets.FixedLengthField;
import pl.cwanix.opensun.utils.packets.PacketHeader;

public class C2SAskCreateNewCharPacket extends ClientPacket {
	
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

		restTemplate.postForObject("http://" + properties.getDb().getIp() + ":" + properties.getDb().getPort()
				+ "/character/create?accountId=" + session.getUser().getAccount().getId()
				+ "&name=" + charName.toString()
				+ "&classCode=" + classCode.getValue()[0]
				+ "&heightCode=" + heightCode.getValue()[0]
				+ "&faceCode=" + faceCode.getValue()[0]
				+ "&hairCode=" + hairCode.getValue()[0]
				+ "&slot=" + 1,
				null, Integer.class);
		
		S2CAnsCreateNewCharPacket ansCreateNewCharPackiet = new S2CAnsCreateNewCharPacket();
		ansCreateNewCharPackiet.process(ctx);
		
		ctx.writeAndFlush(ansCreateNewCharPackiet);
	}

}
