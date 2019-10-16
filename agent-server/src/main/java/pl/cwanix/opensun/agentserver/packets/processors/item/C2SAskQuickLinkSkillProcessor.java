package pl.cwanix.opensun.agentserver.packets.processors.item;

import io.netty.channel.ChannelHandlerContext;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import pl.cwanix.opensun.agentserver.packets.c2s.item.C2SAskQuickLinkSkillPacket;
import pl.cwanix.opensun.agentserver.packets.s2c.item.S2CAnsQuickLinkSkillPacket;
import pl.cwanix.opensun.commonserver.packets.SUNPacketProcessor;
import pl.cwanix.opensun.commonserver.packets.annotations.PacketProcessor;

@Slf4j
@RequiredArgsConstructor
@PacketProcessor(packetClass = C2SAskQuickLinkSkillPacket.class)
public class C2SAskQuickLinkSkillProcessor implements SUNPacketProcessor<C2SAskQuickLinkSkillPacket> {

    @Override
    public void process(ChannelHandlerContext ctx, C2SAskQuickLinkSkillPacket packet) {
        ctx.writeAndFlush(new S2CAnsQuickLinkSkillPacket(packet.getSlotCode().toShort(), packet.getPosition().toByte()));
    }
}
