package pl.cwanix.opensun.agentserver.packets.c2s.skill;

import io.netty.channel.ChannelHandlerContext;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Marker;
import org.slf4j.MarkerFactory;
import pl.cwanix.opensun.agentserver.server.context.AgentServerContext;
import pl.cwanix.opensun.commonserver.packets.annotations.IncomingPacket;
import pl.cwanix.opensun.commonserver.packets.Packet;
import pl.cwanix.opensun.commonserver.packets.PacketCategory;

@Slf4j
@IncomingPacket(category = PacketCategory.SKILL, type = (byte) 0xC5)
public class C2SAskAddSkillPointPacket implements Packet<AgentServerContext> {

	private static final Marker MARKER = MarkerFactory.getMarker("C2S -> ADD SKILL POINT");

	public C2SAskAddSkillPointPacket(byte[] value) {

	}

	@Override
	public void process(ChannelHandlerContext ctx, AgentServerContext srv) {

	}
}
