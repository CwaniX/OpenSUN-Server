package pl.cwanix.opensun.agentserver.packets.c2s.connection;

import org.springframework.web.client.RestTemplate;

import io.netty.channel.ChannelHandlerContext;
import pl.cwanix.opensun.agentserver.entities.CharacterEntity;
import pl.cwanix.opensun.agentserver.packets.s2c.characters.S2CAnsItemsPacket;
import pl.cwanix.opensun.agentserver.packets.s2c.characters.S2CAnsQuickPacket;
import pl.cwanix.opensun.agentserver.packets.s2c.characters.S2CAnsSkillsPacket;
import pl.cwanix.opensun.agentserver.packets.s2c.characters.S2CAnsStatePacket;
import pl.cwanix.opensun.agentserver.packets.s2c.characters.S2CAnsStylePacket;
import pl.cwanix.opensun.agentserver.packets.s2c.connection.S2CAnsEnterVillagePacket;
import pl.cwanix.opensun.agentserver.properties.AgentServerProperties;
import pl.cwanix.opensun.agentserver.server.AgentServerChannelHandler;
import pl.cwanix.opensun.agentserver.server.session.AgentServerSession;
import pl.cwanix.opensun.commonserver.packets.IncomingPacket;
import pl.cwanix.opensun.commonserver.packets.Packet;
import pl.cwanix.opensun.commonserver.packets.PacketCategory;
import pl.cwanix.opensun.utils.datatypes.FixedLengthField;

@IncomingPacket(category = PacketCategory.CONNECTION, type = 0x1F)
public class C2SAskEnterVillagePacket implements Packet {
	
	private FixedLengthField selectedChar;
	
	public C2SAskEnterVillagePacket(byte[] value) {
		selectedChar = new FixedLengthField(1, value[0]);
	}

	@Override
	public void process(ChannelHandlerContext ctx) {
		AgentServerSession session = ctx.channel().attr(AgentServerChannelHandler.SESSION_ATTRIBUTE).get();
		RestTemplate restTemplate = ctx.channel().attr(AgentServerChannelHandler.REST_TEMPLATE_ATTRIBUTE).get();
		AgentServerProperties properties = ctx.channel().attr(AgentServerChannelHandler.PROPERIES_ATTRIBUTE).get();
		
		CharacterEntity selectedCharacter = restTemplate.getForObject(properties.getDb().getServerUrl()
				+ "/character/findByAccountIdAndSlot?accountId="
				+ session.getUser().getAccount().getId()
				+ "&slot="
				+ selectedChar.toByteArray()[0], CharacterEntity.class);		
		
		session.setCharacter(selectedCharacter);
		
		ctx.writeAndFlush(new S2CAnsItemsPacket());
		ctx.writeAndFlush(new S2CAnsSkillsPacket());
		ctx.writeAndFlush(new S2CAnsQuickPacket());
		ctx.writeAndFlush(new S2CAnsStylePacket());
		ctx.writeAndFlush(new S2CAnsStatePacket());
		ctx.writeAndFlush(new S2CAnsEnterVillagePacket());
	}
}
