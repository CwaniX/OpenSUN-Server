package pl.cwanix.opensun.agentserver.packets.c2s.sync;

import java.util.Arrays;

import org.slf4j.Marker;
import org.slf4j.MarkerFactory;

import io.netty.channel.ChannelHandlerContext;
import lombok.extern.slf4j.Slf4j;
import pl.cwanix.opensun.agentserver.server.AgentServerChannelHandler;
import pl.cwanix.opensun.agentserver.server.context.AgentServerContext;
import pl.cwanix.opensun.agentserver.server.session.AgentServerSession;
import pl.cwanix.opensun.commonserver.packets.annotations.IncomingPacket;
import pl.cwanix.opensun.commonserver.packets.Packet;
import pl.cwanix.opensun.commonserver.packets.PacketCategory;
import pl.cwanix.opensun.utils.datatypes.FixedLengthField;
import pl.cwanix.opensun.utils.datatypes.Vector;

@Slf4j
@IncomingPacket(category = PacketCategory.SYNC, type = (byte) 0xCA)
public class C2SAskMouseMovePacket implements Packet<AgentServerContext> {
	
	private static final Marker MARKER = MarkerFactory.getMarker("C2S -> MOUSE MOVE");
	
	private FixedLengthField unknown;
	private Vector currentPosition;
	private Vector destinationPosition;
	
	public C2SAskMouseMovePacket(byte[] value) {
		unknown = new FixedLengthField(1, value[0]);
		currentPosition = new Vector(Arrays.copyOfRange(value, 1, 13));
		currentPosition = new Vector(Arrays.copyOfRange(value, 13, value.length));
	}

	@Override
	public void process(ChannelHandlerContext ctx, AgentServerContext srv) {
		AgentServerSession session = ctx.channel().attr(AgentServerChannelHandler.SESSION_ATTRIBUTE).get();
		
		log.debug(MARKER, "Updating character position: {} {} {}", currentPosition.getX(), currentPosition.getY(), currentPosition.getZ());
		
		srv.getDbConnector().updateCharacterPosition(session.getCharacter().getId(), currentPosition.getX(), currentPosition.getY(), currentPosition.getZ());
	}

}
