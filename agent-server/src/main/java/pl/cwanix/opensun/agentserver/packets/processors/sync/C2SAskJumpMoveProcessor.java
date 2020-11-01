package pl.cwanix.opensun.agentserver.packets.processors.sync;

import io.netty.channel.ChannelHandlerContext;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import pl.cwanix.opensun.agentserver.packets.c2s.sync.C2SAskJumpMovePacket;
import pl.cwanix.opensun.commonserver.packets.SUNPacketProcessor;
import pl.cwanix.opensun.commonserver.packets.annotations.PacketProcessor;

@Slf4j
@RequiredArgsConstructor
@PacketProcessor(packetClass = C2SAskJumpMovePacket.class)
public class C2SAskJumpMoveProcessor implements SUNPacketProcessor<C2SAskJumpMovePacket> {

    @Override
    public void process(final ChannelHandlerContext ctx, final C2SAskJumpMovePacket packet) {

    }
}
