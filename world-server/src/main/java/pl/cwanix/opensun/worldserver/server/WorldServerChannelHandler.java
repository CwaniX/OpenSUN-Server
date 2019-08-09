package pl.cwanix.opensun.worldserver.server;

import io.netty.channel.ChannelHandlerContext;
import lombok.RequiredArgsConstructor;
import pl.cwanix.opensun.commonserver.packets.Packet;
import pl.cwanix.opensun.commonserver.server.SUNServerChannelHandler;
import pl.cwanix.opensun.worldserver.server.context.WorldServerContext;

@RequiredArgsConstructor
public class WorldServerChannelHandler extends SUNServerChannelHandler {
	
	private final WorldServerContext srv;

	@Override
	@SuppressWarnings("unchecked")
    public void channelRead(ChannelHandlerContext ctx, Object msg) {
    	Packet<WorldServerContext> packet = (Packet<WorldServerContext>) msg;
    	packet.process(ctx, srv);
    }
}
