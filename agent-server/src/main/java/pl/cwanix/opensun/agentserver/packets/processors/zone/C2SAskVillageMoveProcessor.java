package pl.cwanix.opensun.agentserver.packets.processors.zone;

import io.netty.channel.ChannelHandlerContext;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import pl.cwanix.opensun.agentserver.packets.c2s.zone.C2SAskVillageMovePacket;
import pl.cwanix.opensun.agentserver.packets.s2c.sync.S2CAnsPlayerEnterPacket;
import pl.cwanix.opensun.agentserver.packets.s2c.zone.S2CAnsVillageMovePacket;
import pl.cwanix.opensun.commonserver.packets.SUNPacketProcessor;
import pl.cwanix.opensun.commonserver.packets.annotations.PacketProcessor;

@Slf4j
@RequiredArgsConstructor
@PacketProcessor(packetClass = C2SAskVillageMovePacket.class)
public class C2SAskVillageMoveProcessor implements SUNPacketProcessor<C2SAskVillageMovePacket> {

    @Override
    public void process(ChannelHandlerContext ctx, C2SAskVillageMovePacket packet) {
        ctx.writeAndFlush(new S2CAnsVillageMovePacket());
    }
}
