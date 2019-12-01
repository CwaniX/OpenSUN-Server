package pl.cwanix.opensun.agentserver.packets.processors.sync;

import io.netty.channel.ChannelHandlerContext;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Marker;
import org.slf4j.MarkerFactory;
import pl.cwanix.opensun.agentserver.communication.DatabaseProxyConnector;
import pl.cwanix.opensun.agentserver.packets.c2s.sync.C2SAskMouseMovePacket;
import pl.cwanix.opensun.agentserver.server.AgentServerChannelHandler;
import pl.cwanix.opensun.agentserver.server.session.AgentServerSession;
import pl.cwanix.opensun.commonserver.packets.SUNPacketProcessor;
import pl.cwanix.opensun.commonserver.packets.annotations.PacketProcessor;

@Slf4j
@RequiredArgsConstructor
@PacketProcessor(packetClass = C2SAskMouseMovePacket.class)
public class C2SAskMouseMoveProcessor implements SUNPacketProcessor<C2SAskMouseMovePacket> {

    private static final Marker MARKER = MarkerFactory.getMarker("C2S -> MOUSE MOVE");

    private final DatabaseProxyConnector databaseProxyConnector;

    @Override
    public void process(ChannelHandlerContext ctx, C2SAskMouseMovePacket packet) {
        AgentServerSession session = ctx.channel().attr(AgentServerChannelHandler.SESSION_ATTRIBUTE).get();

        log.debug(MARKER, "Updating character position: {} {} {}", packet.getDestinationPosition().getX(), packet.getDestinationPosition().getY(), packet.getDestinationPosition().getZ());

        databaseProxyConnector.updateCharacterPosition(session.getCharacter().getId(), packet.getDestinationPosition().getX(), packet.getDestinationPosition().getY(), packet.getDestinationPosition().getZ(), 0);
    }
}
