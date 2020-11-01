package pl.cwanix.opensun.agentserver.packets.processors.zone;

import io.netty.channel.ChannelHandlerContext;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import pl.cwanix.opensun.agentserver.packets.c2s.zone.C2SAskVillageMovePacket;
import pl.cwanix.opensun.agentserver.packets.s2c.zone.S2CAnsVillageMovePacket;
import pl.cwanix.opensun.agentserver.server.AgentServerChannelHandler;
import pl.cwanix.opensun.agentserver.server.session.AgentServerSession;
import pl.cwanix.opensun.commonserver.packets.SUNPacketProcessor;
import pl.cwanix.opensun.commonserver.packets.annotations.PacketProcessor;
import pl.cwanix.opensun.domain.CharacterDTO;

@SuppressWarnings("checkstyle:MagicNumber")
@Slf4j
@RequiredArgsConstructor
@PacketProcessor(packetClass = C2SAskVillageMovePacket.class)
public class C2SAskVillageMoveProcessor implements SUNPacketProcessor<C2SAskVillageMovePacket> {

    @Override
    public void process(final ChannelHandlerContext ctx, final C2SAskVillageMovePacket packet) {
        AgentServerSession session = ctx.channel().attr(AgentServerChannelHandler.SESSION_ATTRIBUTE).get();

        CharacterDTO character = session.getCharacter();
        character.getPosition().setRegion(20004);
        character.getPosition().setLocationX(169.90472F);
        character.getPosition().setLocationY(267.42834F);
        character.getPosition().setLocationZ(33.776058F);

        ctx.writeAndFlush(new S2CAnsVillageMovePacket());
    }
}
