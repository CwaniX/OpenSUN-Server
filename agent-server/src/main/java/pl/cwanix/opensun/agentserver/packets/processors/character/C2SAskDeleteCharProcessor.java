package pl.cwanix.opensun.agentserver.packets.processors.character;

import io.netty.channel.ChannelHandlerContext;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Marker;
import org.slf4j.MarkerFactory;
import pl.cwanix.opensun.agentserver.communication.DatabaseProxyConnector;
import pl.cwanix.opensun.agentserver.packets.c2s.character.C2SAskDeleteCharPacket;
import pl.cwanix.opensun.agentserver.packets.s2c.characters.S2CAnsDeleteCharPacket;
import pl.cwanix.opensun.agentserver.packets.s2c.characters.S2CErrDeleteCharPacket;
import pl.cwanix.opensun.agentserver.server.AgentServerChannelHandler;
import pl.cwanix.opensun.agentserver.server.session.AgentServerSession;
import pl.cwanix.opensun.commonserver.packets.SUNPacketProcessor;
import pl.cwanix.opensun.commonserver.packets.annotations.PacketProcessor;

@Slf4j
@RequiredArgsConstructor
@PacketProcessor(packetClass = C2SAskDeleteCharPacket.class)
public class C2SAskDeleteCharProcessor implements SUNPacketProcessor<C2SAskDeleteCharPacket> {

    private static final Marker MARKER = MarkerFactory.getMarker("C2S -> DELETE CHAR");
    private static final String DELETE_WORD = "delete";

    private final DatabaseProxyConnector databaseProxyConnector;

    @Override
    public void process(final ChannelHandlerContext ctx, final C2SAskDeleteCharPacket packet) {
        AgentServerSession session = ctx.channel().attr(AgentServerChannelHandler.SESSION_ATTRIBUTE).get();

        if (DELETE_WORD.equals(packet.getDeleteWord().toString())) {
            log.info(MARKER, "Deleting character");
            databaseProxyConnector.deleteCharacter(session.getUser().getAccount().getId(), packet.getSlotNumber().toByteArray()[0]);

            ctx.writeAndFlush(new S2CAnsDeleteCharPacket());
        } else {
            log.info(MARKER, "Unable to delete character");

            //TODO: Error codes
            ctx.writeAndFlush(new S2CErrDeleteCharPacket(0));
        }

    }
}
