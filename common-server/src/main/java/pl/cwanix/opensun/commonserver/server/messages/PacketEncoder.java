package pl.cwanix.opensun.commonserver.server.messages;

import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToMessageEncoder;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Marker;
import org.slf4j.MarkerFactory;
import pl.cwanix.opensun.commonserver.packets.Packet;
import pl.cwanix.opensun.utils.bytes.BytesUtils;

import java.util.List;

@Slf4j
@ChannelHandler.Sharable
@RequiredArgsConstructor
public class PacketEncoder extends MessageToMessageEncoder<Packet> {
	
	private static final Marker MARKER = MarkerFactory.getMarker("PACKET ENCODER");

	@Override
	protected void encode(ChannelHandlerContext ctx, Packet msg, List<Object> out) throws Exception {
		byte[] result = msg.toByteArray();
		
		log.debug(MARKER, "Outgoing data: {}", BytesUtils.byteArrayToHexString(result));
		
	    out.add(result);
	}

}
