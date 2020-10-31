package pl.cwanix.opensun.authserver.server;

import io.netty.channel.ChannelHandlerContext;
import io.netty.util.AttributeKey;
import lombok.RequiredArgsConstructor;
import pl.cwanix.opensun.authserver.packet.s2c.auth.S2CAnsHelloPacket;
import pl.cwanix.opensun.authserver.server.session.AuthServerSession;
import pl.cwanix.opensun.authserver.server.session.AuthServerSessionManager;
import pl.cwanix.opensun.commonserver.packets.Packet;
import pl.cwanix.opensun.commonserver.packets.SUNPacketProcessorExecutor;
import pl.cwanix.opensun.commonserver.server.SUNServerChannelHandler;

@RequiredArgsConstructor
public class AuthServerChannelHandler extends SUNServerChannelHandler {

    public static final AttributeKey<AuthServerSession> SESSION_ATTRIBUTE = AttributeKey.valueOf("session");

    private final SUNPacketProcessorExecutor processorExecutor;
    private final AuthServerSessionManager sessionManager;

    @Override
    public void channelActive(final ChannelHandlerContext ctx) {
        AuthServerSession session = sessionManager.startNewSession(null);
        ctx.channel().attr(SESSION_ATTRIBUTE).set(session);

        S2CAnsHelloPacket packet = new S2CAnsHelloPacket(session.getEncKey());

        ctx.writeAndFlush(packet);
    }

    @Override
    @SuppressWarnings("unchecked")
    public void channelRead(final ChannelHandlerContext ctx, final Object msg) {
        Packet packet = (Packet) msg;
        processorExecutor.process(ctx, packet);
    }
}
