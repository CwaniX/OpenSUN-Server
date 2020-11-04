package pl.cwanix.opensun.agentserver.packets.processors.sync;

import io.netty.channel.ChannelHandlerContext;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import pl.cwanix.opensun.model.character.CharacterModel;
import pl.cwanix.opensun.agentserver.packets.c2s.sync.C2SAskPlayerEnterPacket;
import pl.cwanix.opensun.agentserver.packets.s2c.sync.S2CAnsAllPlayersEquipInfoPacket;
import pl.cwanix.opensun.agentserver.packets.s2c.sync.S2CAnsAllPlayersGuildInfoPacket;
import pl.cwanix.opensun.agentserver.packets.s2c.sync.S2CAnsPlayerEnterPacket;
import pl.cwanix.opensun.agentserver.server.AgentServerChannelHandler;
import pl.cwanix.opensun.agentserver.server.session.AgentServerSession;
import pl.cwanix.opensun.commonserver.packets.SUNPacketProcessor;
import pl.cwanix.opensun.commonserver.packets.annotations.PacketProcessor;

@Slf4j
@RequiredArgsConstructor
@PacketProcessor(packetClass = C2SAskPlayerEnterPacket.class)
public class C2SAskPlayerEnterProcessor implements SUNPacketProcessor<C2SAskPlayerEnterPacket> {

    @Override
    public void process(final ChannelHandlerContext ctx, final C2SAskPlayerEnterPacket packet) {
        AgentServerSession session = ctx.channel().attr(AgentServerChannelHandler.SESSION_ATTRIBUTE).get();

        CharacterModel character = session.getCharacter();

        ctx.writeAndFlush(new S2CAnsPlayerEnterPacket(character));
        ctx.writeAndFlush(new S2CAnsAllPlayersGuildInfoPacket());
        ctx.writeAndFlush(new S2CAnsAllPlayersEquipInfoPacket());
    }
}
