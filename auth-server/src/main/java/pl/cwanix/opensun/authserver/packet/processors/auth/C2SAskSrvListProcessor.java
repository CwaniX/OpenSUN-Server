package pl.cwanix.opensun.authserver.packet.processors.auth;

import io.netty.channel.ChannelHandlerContext;
import lombok.RequiredArgsConstructor;
import pl.cwanix.opensun.authserver.packet.c2s.auth.C2SAskSrvListPacket;
import pl.cwanix.opensun.authserver.packet.s2c.auth.S2CAnsSrvListPacket;
import pl.cwanix.opensun.authserver.packet.s2c.auth.S2CAnsSrvStatePacket;
import pl.cwanix.opensun.authserver.packet.structures.ChannelUnitStructure;
import pl.cwanix.opensun.authserver.packet.structures.ServerUnitStructure;
import pl.cwanix.opensun.commonserver.packets.SUNPacketProcessor;
import pl.cwanix.opensun.commonserver.packets.annotations.PacketProcessor;
import pl.cwanix.opensun.model.server.ServerDataSource;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@PacketProcessor(packetClass = C2SAskSrvListPacket.class)
public class C2SAskSrvListProcessor implements SUNPacketProcessor<C2SAskSrvListPacket> {

    private final ServerDataSource serverDataSource;

    @Override
    public void process(final ChannelHandlerContext ctx, final C2SAskSrvListPacket packet) {
        List<ServerUnitStructure> serversList = serverDataSource.findServers()
                .stream()
                .map(ServerUnitStructure::new)
                .collect(Collectors.toList());

        List<ChannelUnitStructure> channelsList = serverDataSource.findChannels()
                .stream()
                .map(ChannelUnitStructure::new)
                .collect(Collectors.toList());

        ctx.writeAndFlush(new S2CAnsSrvListPacket(serversList));
        ctx.writeAndFlush(new S2CAnsSrvStatePacket(channelsList));
    }
}
