package pl.cwanix.opensun.agentserver.packets.c2s.zone;

import org.slf4j.Marker;
import org.slf4j.MarkerFactory;

import io.netty.channel.ChannelHandlerContext;
import lombok.extern.slf4j.Slf4j;
import pl.cwanix.opensun.agentserver.packets.s2c.sync.S2CAnsVillageMovePacket;
import pl.cwanix.opensun.commonserver.packets.IncomingPacket;
import pl.cwanix.opensun.commonserver.packets.Packet;
import pl.cwanix.opensun.commonserver.packets.PacketCategory;
import pl.cwanix.opensun.utils.bytes.BytesUtils;
import pl.cwanix.opensun.utils.datatypes.FixedLengthField;

@Slf4j
@IncomingPacket(category = PacketCategory.ZONE, type = (byte) 0xCC)
public class C2SAskVillageMovePacket implements Packet {
	
	private static final Marker MARKER = MarkerFactory.getMarker("C2S -> VILLAGE MOVE");
	
	private FixedLengthField villageMapCode;
	
	public C2SAskVillageMovePacket(byte[] value) {
		villageMapCode = new FixedLengthField(2, value);
	}

	@Override
	public void process(ChannelHandlerContext ctx) {
		log.debug(MARKER, "Moving to map: {}", BytesUtils.byteArrayToShort(villageMapCode.toByteArray()));
		
		ctx.writeAndFlush(new S2CAnsVillageMovePacket(BytesUtils.byteArrayToShort(villageMapCode.toByteArray()), 0x68));
	}

}
