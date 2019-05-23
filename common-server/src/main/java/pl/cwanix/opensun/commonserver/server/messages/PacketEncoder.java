package pl.cwanix.opensun.commonserver.server.messages;

import java.util.List;

import org.slf4j.Marker;
import org.slf4j.MarkerFactory;

import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToMessageEncoder;
import lombok.extern.slf4j.Slf4j;
import pl.cwanix.opensun.commonserver.packets.ServerPacket;
import pl.cwanix.opensun.utils.bytes.BytesUtils;

@Slf4j
@ChannelHandler.Sharable
public class PacketEncoder extends MessageToMessageEncoder<ServerPacket> {
	
	private static final Marker MARKER = MarkerFactory.getMarker("PACKET ENCODER");

	@Override
	protected void encode(ChannelHandlerContext ctx, ServerPacket msg, List<Object> out) throws Exception {
		log.debug(MARKER, "Outgoing data: {}", BytesUtils.byteArrayToHexString(msg.toByteArray()));
		
	    out.add(msg.toByteArray());
	}

}
