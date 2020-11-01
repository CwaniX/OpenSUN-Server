package pl.cwanix.opensun.agentserver.packets.processors.skill;

import io.netty.channel.ChannelHandlerContext;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Marker;
import org.slf4j.MarkerFactory;
import pl.cwanix.opensun.agentserver.packets.c2s.skill.C2SAskAddSkillPointPacket;
import pl.cwanix.opensun.commonserver.packets.SUNPacketProcessor;
import pl.cwanix.opensun.commonserver.packets.annotations.PacketProcessor;

@Slf4j
@RequiredArgsConstructor
@PacketProcessor(packetClass = C2SAskAddSkillPointPacket.class)
public class C2SAskAddSkillPointProcessor implements SUNPacketProcessor<C2SAskAddSkillPointPacket> {

    private static final Marker MARKER = MarkerFactory.getMarker("C2S -> ADD SKILL POINT");

    @Override
    public void process(final ChannelHandlerContext ctx, final C2SAskAddSkillPointPacket packet) {

    }
}
