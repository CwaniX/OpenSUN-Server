package pl.cwanix.opensun.agentserver.packets.processors.character;

import io.netty.channel.ChannelHandlerContext;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import pl.cwanix.opensun.agentserver.packets.c2s.character.C2SAskFreeCharNamePacket;
import pl.cwanix.opensun.commonserver.packets.SUNPacketProcessor;
import pl.cwanix.opensun.commonserver.packets.annotations.PacketProcessor;

@Slf4j
@RequiredArgsConstructor
@PacketProcessor(packetClass = C2SAskFreeCharNamePacket.class)
public class C2SAskFreeCharNameProcessor implements SUNPacketProcessor<C2SAskFreeCharNamePacket> {

    @Override
    public void process(final ChannelHandlerContext ctx, final C2SAskFreeCharNamePacket packet) {
        //TODO:
    }
}
