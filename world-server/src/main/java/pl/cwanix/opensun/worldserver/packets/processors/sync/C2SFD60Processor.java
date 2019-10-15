package pl.cwanix.opensun.worldserver.packets.processors.sync;

import io.netty.channel.ChannelHandlerContext;
import lombok.RequiredArgsConstructor;
import pl.cwanix.opensun.commonserver.packets.SUNPacketProcessor;
import pl.cwanix.opensun.commonserver.packets.annotations.PacketProcessor;
import pl.cwanix.opensun.worldserver.packets.c2s.sync.C2SFD60Packet;

@RequiredArgsConstructor
@PacketProcessor(packetClass = C2SFD60Packet.class)
public class C2SFD60Processor implements SUNPacketProcessor<C2SFD60Packet> {

    @Override
    public void process(ChannelHandlerContext ctx, C2SFD60Packet packet) {

    }
}
