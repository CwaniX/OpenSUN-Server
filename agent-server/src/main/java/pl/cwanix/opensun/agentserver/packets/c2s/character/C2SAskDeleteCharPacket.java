package pl.cwanix.opensun.agentserver.packets.c2s.character;

import java.util.Arrays;

import lombok.Getter;
import org.slf4j.Marker;
import org.slf4j.MarkerFactory;

import io.netty.channel.ChannelHandlerContext;
import lombok.extern.slf4j.Slf4j;
import pl.cwanix.opensun.agentserver.packets.s2c.characters.S2CAnsDeleteCharPacket;
import pl.cwanix.opensun.agentserver.packets.s2c.characters.S2CErrDeleteCharPacket;
import pl.cwanix.opensun.agentserver.server.AgentServerChannelHandler;
import pl.cwanix.opensun.agentserver.server.context.AgentServerContext;
import pl.cwanix.opensun.agentserver.server.session.AgentServerSession;
import pl.cwanix.opensun.commonserver.packets.annotations.IncomingPacket;
import pl.cwanix.opensun.commonserver.packets.Packet;
import pl.cwanix.opensun.commonserver.packets.PacketCategory;
import pl.cwanix.opensun.utils.datatypes.FixedLengthField;

@Slf4j
@Getter
@IncomingPacket(category = PacketCategory.CHARACTER, type = (byte) 0x89)
public class C2SAskDeleteCharPacket implements Packet {

	private FixedLengthField slotNumber;
	private FixedLengthField deleteWord;
	
	public C2SAskDeleteCharPacket(byte[] value) {
		this.slotNumber = new FixedLengthField(1, value[0]);
		this.deleteWord = new FixedLengthField(10, Arrays.copyOfRange(value, 1, value.length));
	}
}
