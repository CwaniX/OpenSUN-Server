package pl.cwanix.opensun.worldserver.server;

import io.netty.channel.ChannelHandlerContext;
import lombok.RequiredArgsConstructor;
import pl.cwanix.opensun.commonserver.packets.Packet;
import pl.cwanix.opensun.commonserver.packets.SUNPacketProcessorExecutor;
import pl.cwanix.opensun.commonserver.server.SUNServerChannelHandler;

@RequiredArgsConstructor
public class WorldServerChannelHandler extends SUNServerChannelHandler {

    private final SUNPacketProcessorExecutor packetProcessorExecutor;

    @Override
    @SuppressWarnings("unchecked")
    public void channelRead(final ChannelHandlerContext ctx, final Object msg) {
        Packet packet = (Packet) msg;
        packetProcessorExecutor.process(ctx, packet);
    }
}
