package pl.cwanix.opensun.worldserver.packets.processors.sync;

import io.netty.channel.ChannelHandlerContext;
import lombok.RequiredArgsConstructor;
import pl.cwanix.opensun.commonserver.packets.SUNPacketProcessor;
import pl.cwanix.opensun.commonserver.packets.annotations.PacketProcessor;
import pl.cwanix.opensun.worldserver.packets.c2s.connection.C2S483CPacket;

@RequiredArgsConstructor
@PacketProcessor(packetClass = C2S483CPacket.class)
public class C2S483CProcessor implements SUNPacketProcessor<C2S483CPacket> {

    @Override
    public void process(final ChannelHandlerContext ctx, final C2S483CPacket packet) {

    }
}
