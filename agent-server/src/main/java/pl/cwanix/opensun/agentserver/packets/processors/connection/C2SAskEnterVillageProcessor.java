package pl.cwanix.opensun.agentserver.packets.processors.connection;

import io.netty.channel.ChannelHandlerContext;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import pl.cwanix.opensun.agentserver.communication.DatabaseProxyConnector;
import pl.cwanix.opensun.agentserver.entities.CharacterEntity;
import pl.cwanix.opensun.agentserver.packets.c2s.connection.C2SAskEnterVillagePacket;
import pl.cwanix.opensun.agentserver.packets.s2c.characters.*;
import pl.cwanix.opensun.agentserver.packets.s2c.connection.S2CAnsEnterVillagePacket;
import pl.cwanix.opensun.agentserver.server.AgentServerChannelHandler;
import pl.cwanix.opensun.agentserver.server.session.AgentServerSession;
import pl.cwanix.opensun.commonserver.packets.SUNPacketProcessor;
import pl.cwanix.opensun.commonserver.packets.annotations.PacketProcessor;

@Slf4j
@RequiredArgsConstructor
@PacketProcessor(packetClass = C2SAskEnterVillagePacket.class)
public class C2SAskEnterVillageProcessor implements SUNPacketProcessor<C2SAskEnterVillagePacket> {

	private final DatabaseProxyConnector databaseProxyConnector;

	@Override
	public void process(ChannelHandlerContext ctx, C2SAskEnterVillagePacket packet) {
		AgentServerSession session = ctx.channel().attr(AgentServerChannelHandler.SESSION_ATTRIBUTE).get();

		CharacterEntity selectedCharacter = databaseProxyConnector.findCharacter(session.getUser().getAccount().getId(), packet.getSelectedChar().toByte());

		session.setCharacter(selectedCharacter);

		//TODO:
		ctx.writeAndFlush(new S2CAnsItemsPacket());
		ctx.writeAndFlush(new S2CAnsSkillsPacket());
		ctx.writeAndFlush(new S2CAnsQuickPacket());
		ctx.writeAndFlush(new S2CAnsStylePacket());
		ctx.writeAndFlush(new S2CAnsStatePacket());
		ctx.writeAndFlush(new S2CAnsEnterVillagePacket(selectedCharacter.getId()));
	}
}
