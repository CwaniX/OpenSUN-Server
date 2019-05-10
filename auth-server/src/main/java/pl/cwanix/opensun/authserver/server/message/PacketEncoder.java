package pl.cwanix.opensun.authserver.server.message;

import java.util.List;

import org.springframework.stereotype.Component;

import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToMessageEncoder;
import pl.cwanix.opensun.authserver.packet.s2c.ServerPacket;
import pl.cwanix.opensun.utils.packets.PacketUtils;

@Component
@ChannelHandler.Sharable
public class PacketEncoder extends MessageToMessageEncoder<ServerPacket> {

	@Override
	protected void encode(ChannelHandlerContext ctx, ServerPacket msg, List<Object> out) throws Exception {
		//ystem.out.println("S2C " + PacketUtils.byteArrayToHexString(msg.toByteArray()));
		
	    out.add(msg.toByteArray());
	}

}
