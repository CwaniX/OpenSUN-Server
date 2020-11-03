package pl.cwanix.opensun.agentserver.packets.processors.character;

import io.netty.channel.ChannelHandlerContext;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Marker;
import org.slf4j.MarkerFactory;
import pl.cwanix.opensun.agentserver.communication.DatabaseProxyCharacterDataSourceImpl;
import pl.cwanix.opensun.agentserver.packets.c2s.character.C2SAskCreateCharPacket;
import pl.cwanix.opensun.agentserver.packets.s2c.characters.S2CAnsCreateCharPacket;
import pl.cwanix.opensun.agentserver.server.AgentServerChannelHandler;
import pl.cwanix.opensun.agentserver.server.session.AgentServerSession;
import pl.cwanix.opensun.commonserver.packets.SUNPacketProcessor;
import pl.cwanix.opensun.commonserver.packets.annotations.PacketProcessor;
import pl.cwanix.opensun.model.character.CharacterModel;

@Slf4j
@RequiredArgsConstructor
@PacketProcessor(packetClass = C2SAskCreateCharPacket.class)
public class C2SAskCreateCharProcessor implements SUNPacketProcessor<C2SAskCreateCharPacket> {

    private static final Marker MARKER = MarkerFactory.getMarker("C2S -> CREATE CHAR");

    private final DatabaseProxyCharacterDataSourceImpl databaseProxyCharacterDataSourceImpl;

    @Override
    public void process(final ChannelHandlerContext ctx, final C2SAskCreateCharPacket packet) {
        AgentServerSession session = ctx.channel().attr(AgentServerChannelHandler.SESSION_ATTRIBUTE).get();

        log.info(MARKER, "Creating new character");

        int slot = databaseProxyCharacterDataSourceImpl.findFreeSlot(session.getUser().getAccount().getId());

        if (slot > -1) {
            databaseProxyCharacterDataSourceImpl.createCharacter(
                    session.getUser().getAccount().getId(),
                    packet.getCharName().toString(),
                    packet.getClassCode().toByte(),
                    packet.getHeightCode().toByte(),
                    packet.getFaceCode().toByte(),
                    packet.getHairCode().toByte(),
                    slot);
            CharacterModel characterModel = databaseProxyCharacterDataSourceImpl.findCharacter(session.getUser().getAccount().getId(), slot);

            ctx.writeAndFlush(new S2CAnsCreateCharPacket(characterModel));
        } else {
            //TODO: Error packet
            log.info(MARKER, "Unable to create new character. There is not free slot!");
        }
    }
}
