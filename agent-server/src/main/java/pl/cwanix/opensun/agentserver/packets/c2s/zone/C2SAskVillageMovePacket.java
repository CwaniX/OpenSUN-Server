package pl.cwanix.opensun.agentserver.packets.c2s.zone;

import org.slf4j.Marker;
import org.slf4j.MarkerFactory;

import io.netty.channel.ChannelHandlerContext;
import lombok.extern.slf4j.Slf4j;
import pl.cwanix.opensun.agentserver.packets.s2c.sync.S2CAnsPlayerEnterPacket;
import pl.cwanix.opensun.agentserver.packets.s2c.zone.S2CAnsVillageMovePacket;
import pl.cwanix.opensun.agentserver.server.context.AgentServerContext;
import pl.cwanix.opensun.commonserver.packets.IncomingPacket;
import pl.cwanix.opensun.commonserver.packets.Packet;
import pl.cwanix.opensun.commonserver.packets.PacketCategory;
import pl.cwanix.opensun.utils.bytes.BitField;
import pl.cwanix.opensun.utils.bytes.BytesUtils;

@Slf4j
@IncomingPacket(category = PacketCategory.ZONE, type = (byte) 0xCC)
public class C2SAskVillageMovePacket implements Packet<AgentServerContext> {
	
	private static final Marker MARKER = MarkerFactory.getMarker("C2S -> VILLAGE MOVE");
	
	//private FixedLengthField villageMapCode;
	
	private static final BitField mapCode = new BitField(0b0000000000111111111111111100000000000000000000000000000000000000L);
	
	private long bytes8;
	
	public C2SAskVillageMovePacket(byte[] value) {
		//villageMapCode = new FixedLengthField(1, value);
		System.out.println(BytesUtils.byteArrayToHexString(value));
		bytes8 = BytesUtils.byteArrayToLong(value);
	}

	@Override
	public void process(ChannelHandlerContext ctx, AgentServerContext srv) {
		short newMapNumber = (short) mapCode.getValue(bytes8);
		
		log.info(MARKER, "Moving to map: {} ({})", newMapNumber, mapCode.getValue(bytes8));
		
		ctx.writeAndFlush(new S2CAnsVillageMovePacket(newMapNumber, 0x68));
		ctx.writeAndFlush(new S2CAnsPlayerEnterPacket());
	}

}
