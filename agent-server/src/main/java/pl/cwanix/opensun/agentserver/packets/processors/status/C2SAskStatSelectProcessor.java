package pl.cwanix.opensun.agentserver.packets.processors.status;

import io.netty.channel.ChannelHandlerContext;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Marker;
import org.slf4j.MarkerFactory;
import pl.cwanix.opensun.agentserver.communication.DatabaseProxyCharacterDataSourceImpl;
import pl.cwanix.opensun.agentserver.packets.c2s.status.C2SAskStatSelectPacket;
import pl.cwanix.opensun.agentserver.packets.s2c.status.S2CAnsStatSelectPacket;
import pl.cwanix.opensun.agentserver.packets.s2c.status.S2CErrStatSelectPacket;
import pl.cwanix.opensun.agentserver.server.AgentServerChannelHandler;
import pl.cwanix.opensun.agentserver.server.session.AgentServerSession;
import pl.cwanix.opensun.commonserver.packets.SUNPacketProcessor;
import pl.cwanix.opensun.commonserver.packets.annotations.PacketProcessor;

@SuppressWarnings("checkstyle:MagicNumber")
@Slf4j
@RequiredArgsConstructor
@PacketProcessor(packetClass = C2SAskStatSelectPacket.class)
public class C2SAskStatSelectProcessor implements SUNPacketProcessor<C2SAskStatSelectPacket> {

    private static final Marker MARKER = MarkerFactory.getMarker("C2S -> STAT SELECT");

    private final DatabaseProxyCharacterDataSourceImpl databaseProxyCharacterDataSourceImpl;

    @Override
    public void process(final ChannelHandlerContext ctx, final C2SAskStatSelectPacket packet) {
        AgentServerSession session = ctx.channel().attr(AgentServerChannelHandler.SESSION_ATTRIBUTE).get();

        log.debug(MARKER, "Updating character statistics: {}", packet.getAttributeCode());

        int responseCode = databaseProxyCharacterDataSourceImpl.updateCharacterStatistics(session.getCharacter().getId(), packet.getAttributeCode().toByte());

        if (responseCode == 0) {
            ctx.writeAndFlush(new S2CAnsStatSelectPacket(packet.getAttributeCode().toByte(), 99));
        } else {
            ctx.writeAndFlush(new S2CErrStatSelectPacket(packet.getAttributeCode().toByte(), responseCode));
        }
    }
}
