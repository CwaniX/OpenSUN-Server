package pl.cwanix.opensun.commonserver.server.messages;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;

import org.slf4j.Marker;
import org.slf4j.MarkerFactory;
import org.springframework.web.client.RestTemplate;

import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToMessageDecoder;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import pl.cwanix.opensun.commonserver.packets.ClientPacket;
import pl.cwanix.opensun.utils.bytes.BytesUtils;
import pl.cwanix.opensun.utils.packets.PacketHeader;

@Slf4j
@ChannelHandler.Sharable
@RequiredArgsConstructor
public class PacketDecoder extends MessageToMessageDecoder<byte[]> {
	
	private static final Marker MARKER = MarkerFactory.getMarker("PACKET DECODER");
	
	private final Map<PacketHeader, BiFunction<byte[], byte[], ClientPacket>> clientPacketDefinitions;
	private final RestTemplate restTemplate;

	@Override
	protected void decode(ChannelHandlerContext ctx, byte[] msg, List<Object> out) throws Exception {
		log.debug(MARKER, "Incoming data: {}", BytesUtils.byteArrayToHexString(msg));

		byte[] size = new byte[] { msg[0], msg[1] };
		PacketHeader id = new PacketHeader(msg[2], msg[3]);
		byte[] value = Arrays.copyOfRange(msg, 4, msg.length);
		
		ClientPacket packet = clientPacketDefinitions.get(id).apply(size, value);
		packet.setRestTemplate(restTemplate);
		
		out.add(packet);
	}

}
