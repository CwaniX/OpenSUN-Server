package pl.cwanix.opensun.agentserver.packets.processors.unknown;

import io.netty.channel.ChannelHandlerContext;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import pl.cwanix.opensun.agentserver.packets.c2s.unknown.C2SEA09Packet;
import pl.cwanix.opensun.commonserver.packets.SUNPacketProcessor;
import pl.cwanix.opensun.commonserver.packets.annotations.PacketProcessor;

@Slf4j
@RequiredArgsConstructor
@PacketProcessor(packetClass = C2SEA09Packet.class)
public class C2SEA09Processor implements SUNPacketProcessor<C2SEA09Packet> {

    @Override
    public void process(final ChannelHandlerContext ctx, final C2SEA09Packet packet) {

    }
}
