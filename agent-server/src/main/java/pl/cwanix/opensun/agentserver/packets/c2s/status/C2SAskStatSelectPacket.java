package pl.cwanix.opensun.agentserver.packets.c2s.status;

import org.slf4j.Marker;
import org.slf4j.MarkerFactory;

import io.netty.channel.ChannelHandlerContext;
import lombok.extern.slf4j.Slf4j;
import pl.cwanix.opensun.agentserver.packets.s2c.status.S2CAnsStatSelectPacket;
import pl.cwanix.opensun.agentserver.packets.s2c.status.S2CErrStatSelectPacket;
import pl.cwanix.opensun.agentserver.server.AgentServerChannelHandler;
import pl.cwanix.opensun.agentserver.server.context.AgentServerContext;
import pl.cwanix.opensun.agentserver.server.session.AgentServerSession;
import pl.cwanix.opensun.commonserver.packets.IncomingPacket;
import pl.cwanix.opensun.commonserver.packets.Packet;
import pl.cwanix.opensun.commonserver.packets.PacketCategory;
import pl.cwanix.opensun.utils.datatypes.FixedLengthField;

@Slf4j
@IncomingPacket(category = PacketCategory.STATUS, type = (byte) 0x3C)
public class C2SAskStatSelectPacket implements Packet<AgentServerContext> {
	
	private static final Marker MARKER = MarkerFactory.getMarker("C2S -> STAT SELECT");
	
	private FixedLengthField attributeCode;

	public C2SAskStatSelectPacket(byte[] value) {
		this.attributeCode = new FixedLengthField(1, value);
	}
	
	@Override
	public void process(ChannelHandlerContext ctx, AgentServerContext srv) {
		AgentServerSession session = ctx.channel().attr(AgentServerChannelHandler.SESSION_ATTRIBUTE).get();
		
		log.debug(MARKER, "Updating character statistics: {}", attributeCode);
		
		int responseCode = srv.getDbConnector().updateCharacterStatistics(session.getCharacter().getId(), attributeCode.toByte());
		
		if (responseCode == 0) {
			ctx.writeAndFlush(new S2CAnsStatSelectPacket(attributeCode.toByte(), 99));
		} else {
			ctx.writeAndFlush(new S2CErrStatSelectPacket(attributeCode.toByte(), responseCode));
		}
	}
}
