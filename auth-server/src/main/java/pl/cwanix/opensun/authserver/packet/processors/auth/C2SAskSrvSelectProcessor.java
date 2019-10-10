package pl.cwanix.opensun.authserver.packet.processors.auth;

import io.netty.channel.ChannelHandlerContext;
import lombok.RequiredArgsConstructor;
import pl.cwanix.opensun.authserver.packet.s2c.auth.S2CAnsSrvSelectPacket;
import pl.cwanix.opensun.authserver.server.AuthServerChannelHandler;
import pl.cwanix.opensun.authserver.server.session.AuthServerSession;
import pl.cwanix.opensun.commonserver.packets.SUNPacketProcessor;
import pl.cwanix.opensun.commonserver.packets.annotations.PacketProcessor;

@RequiredArgsConstructor
@PacketProcessor(packetClass = C2SAskSrvSelectProcessor.class)
public class C2SAskSrvSelectProcessor implements SUNPacketProcessor<C2SAskSrvSelectProcessor> {

	@Override
	public void process(ChannelHandlerContext ctx, C2SAskSrvSelectProcessor packet) {
		AuthServerSession session = ctx.channel().attr(AuthServerChannelHandler.SESSION_ATTRIBUTE).get();

		ctx.writeAndFlush(new S2CAnsSrvSelectPacket(session.getUser().getId()));
	}
}
