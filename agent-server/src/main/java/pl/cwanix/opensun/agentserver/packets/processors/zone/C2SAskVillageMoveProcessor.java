package pl.cwanix.opensun.agentserver.packets.processors.zone;

import io.netty.channel.ChannelHandlerContext;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import pl.cwanix.opensun.agentserver.engine.maps.MapInfoManager;
import pl.cwanix.opensun.agentserver.engine.maps.MapPortalInfoManager;
import pl.cwanix.opensun.agentserver.engine.maps.structures.MapInfoStructure;
import pl.cwanix.opensun.agentserver.engine.maps.structures.PortalInfoStructure;
import pl.cwanix.opensun.agentserver.packets.c2s.zone.C2SAskVillageMovePacket;
import pl.cwanix.opensun.agentserver.packets.s2c.zone.S2CAnsVillageMovePacket;
import pl.cwanix.opensun.agentserver.server.AgentServerChannelHandler;
import pl.cwanix.opensun.agentserver.server.session.AgentServerSession;
import pl.cwanix.opensun.commonserver.packets.SUNPacketProcessor;
import pl.cwanix.opensun.commonserver.packets.annotations.PacketProcessor;
import pl.cwanix.opensun.model.character.CharacterDataSource;
import pl.cwanix.opensun.model.character.CharacterModel;

@SuppressWarnings("checkstyle:MagicNumber")
@Slf4j
@RequiredArgsConstructor
@PacketProcessor(packetClass = C2SAskVillageMovePacket.class)
public class C2SAskVillageMoveProcessor implements SUNPacketProcessor<C2SAskVillageMovePacket> {

    private final MapInfoManager mapInfoManager;
    private final MapPortalInfoManager mapPortalInfoManager;
    private final CharacterDataSource characterDataSource;

    @Override
    public void process(final ChannelHandlerContext ctx, final C2SAskVillageMovePacket packet) {
        final AgentServerSession session = ctx.channel().attr(AgentServerChannelHandler.SESSION_ATTRIBUTE).get();

        final PortalInfoStructure portal = mapPortalInfoManager.get(packet.getKey1().toByte(), packet.getKey2().toByte());
        final MapInfoStructure map = mapInfoManager.get(portal.getFieldTo());
        final CharacterModel character = session.getCharacter();

        character.getPosition().setRegion(map.getMapCode());
        character.getPosition().setLocationX(map.getStartingVector().getX());
        character.getPosition().setLocationY(map.getStartingVector().getY());
        character.getPosition().setLocationZ(map.getStartingVector().getZ());

        characterDataSource.updateCharacterRegion(
                character.getId(),
                map.getStartingVector().getX(),
                map.getStartingVector().getY(),
                map.getStartingVector().getZ(),
                0,
                map.getMapCode());

        ctx.writeAndFlush(new S2CAnsVillageMovePacket(portal.getId()));
    }
}
