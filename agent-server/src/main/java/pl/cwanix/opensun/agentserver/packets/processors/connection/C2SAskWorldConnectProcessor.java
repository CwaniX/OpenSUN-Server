package pl.cwanix.opensun.agentserver.packets.processors.connection;

import io.netty.channel.ChannelHandlerContext;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import pl.cwanix.opensun.agentserver.packets.c2s.connection.C2SAskWordConnectPacket;
import pl.cwanix.opensun.agentserver.packets.s2c.connection.S2CAnsWorldConnectPacket;
import pl.cwanix.opensun.agentserver.properties.AgentServerProperties;
import pl.cwanix.opensun.commonserver.packets.SUNPacketProcessor;
import pl.cwanix.opensun.commonserver.packets.annotations.PacketProcessor;

@Slf4j
@RequiredArgsConstructor
@PacketProcessor(packetClass = C2SAskWordConnectPacket.class)
public class C2SAskWorldConnectProcessor implements SUNPacketProcessor<C2SAskWordConnectPacket> {

    private final AgentServerProperties properties;

    @Override
    public void process(final ChannelHandlerContext ctx, final C2SAskWordConnectPacket packet) {
        ctx.writeAndFlush(new S2CAnsWorldConnectPacket(properties.getWorld().getIp(), properties.getWorld().getPort()));
    }
}
