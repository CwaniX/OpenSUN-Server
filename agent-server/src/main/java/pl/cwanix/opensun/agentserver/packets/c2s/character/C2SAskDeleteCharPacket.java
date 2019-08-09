package pl.cwanix.opensun.agentserver.packets.c2s.character;

import java.util.Arrays;

import org.slf4j.Marker;
import org.slf4j.MarkerFactory;

import io.netty.channel.ChannelHandlerContext;
import lombok.extern.slf4j.Slf4j;
import pl.cwanix.opensun.agentserver.packets.s2c.characters.S2CAnsDeleteCharPacket;
import pl.cwanix.opensun.agentserver.packets.s2c.characters.S2CErrDeleteCharPacket;
import pl.cwanix.opensun.agentserver.server.AgentServerChannelHandler;
import pl.cwanix.opensun.agentserver.server.context.AgentServerContext;
import pl.cwanix.opensun.agentserver.server.session.AgentServerSession;
import pl.cwanix.opensun.commonserver.packets.IncomingPacket;
import pl.cwanix.opensun.commonserver.packets.Packet;
import pl.cwanix.opensun.commonserver.packets.PacketCategory;
import pl.cwanix.opensun.utils.datatypes.FixedLengthField;

@Slf4j
@IncomingPacket(category = PacketCategory.CHAR_INFO, type = (byte) 0x89)
public class C2SAskDeleteCharPacket implements Packet<AgentServerContext> {
	
	private static final Marker MARKER = MarkerFactory.getMarker("C2S -> DELETE CHAR");
	
	private static final String DELETE_WORD = "delete";
	
	private FixedLengthField slotNumber;
	private FixedLengthField deleteWord;
	
	public C2SAskDeleteCharPacket(byte[] value) {
		this.slotNumber = new FixedLengthField(1, value[0]);
		this.deleteWord = new FixedLengthField(10, Arrays.copyOfRange(value, 1, value.length));
	}

	@Override
	public void process(ChannelHandlerContext ctx, AgentServerContext srv) {
		AgentServerSession session = ctx.channel().attr(AgentServerChannelHandler.SESSION_ATTRIBUTE).get();
		
		if (DELETE_WORD.equals(deleteWord.toString())) {
			log.info(MARKER, "Deletig character");
			srv.getDbConnector().deleteCharacter(session.getUser().getAccount().getId(), slotNumber.toByteArray()[0]);
			
			ctx.writeAndFlush(new S2CAnsDeleteCharPacket());
		} else {
			log.info(MARKER, "Unable to delete character");
			
			ctx.writeAndFlush(new S2CErrDeleteCharPacket());
		}

	}
}
