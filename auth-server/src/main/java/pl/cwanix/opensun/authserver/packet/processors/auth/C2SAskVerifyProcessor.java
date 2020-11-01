package pl.cwanix.opensun.authserver.packet.processors.auth;

import io.netty.channel.ChannelHandlerContext;
import lombok.RequiredArgsConstructor;
import pl.cwanix.opensun.authserver.packet.c2s.auth.C2SAskVerifyPacket;
import pl.cwanix.opensun.authserver.packet.s2c.auth.S2CAnsVerifyPacket;
import pl.cwanix.opensun.commonserver.packets.SUNPacketProcessor;
import pl.cwanix.opensun.commonserver.packets.annotations.PacketProcessor;

@RequiredArgsConstructor
@PacketProcessor(packetClass = C2SAskVerifyPacket.class)
public class C2SAskVerifyProcessor implements SUNPacketProcessor<C2SAskVerifyPacket> {

    @Override
    public void process(final ChannelHandlerContext ctx, final C2SAskVerifyPacket packet) {
        ctx.writeAndFlush(new S2CAnsVerifyPacket());
    }
}
