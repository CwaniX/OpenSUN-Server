package pl.cwanix.opensun.worldserver.packets.processors.sync;

import io.netty.channel.ChannelHandlerContext;
import lombok.RequiredArgsConstructor;
import pl.cwanix.opensun.commonserver.packets.SUNPacketProcessor;
import pl.cwanix.opensun.commonserver.packets.annotations.PacketProcessor;
import pl.cwanix.opensun.worldserver.packets.c2s.sync.C2S4860Packet;

@RequiredArgsConstructor
@PacketProcessor(packetClass = C2S4860Packet.class)
public class C2S4860Processor implements SUNPacketProcessor<C2S4860Packet> {

    @Override
    public void process(ChannelHandlerContext ctx, C2S4860Packet packet) {

    }
}
