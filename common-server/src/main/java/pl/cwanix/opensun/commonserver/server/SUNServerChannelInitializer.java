package pl.cwanix.opensun.commonserver.server;

import org.springframework.stereotype.Component;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.bytes.ByteArrayDecoder;
import io.netty.handler.codec.bytes.ByteArrayEncoder;
import io.netty.util.concurrent.EventExecutorGroup;
import lombok.RequiredArgsConstructor;
import pl.cwanix.opensun.commonserver.server.messages.PacketDecoder;
import pl.cwanix.opensun.commonserver.server.messages.PacketEncoder;

@Component
@RequiredArgsConstructor
public class SUNServerChannelInitializer extends ChannelInitializer<SocketChannel> {

	private final EventExecutorGroup eventExecutorGroup;
	private final SUNServerChannelHandlerFactory channelFactory;
	private final PacketDecoder packetDecoder;
	private final PacketEncoder packetEncoder;

	@Override
	protected void initChannel(SocketChannel socketChannel) throws Exception {
		socketChannel.pipeline().addLast(new ByteArrayDecoder());
		socketChannel.pipeline().addLast(packetDecoder);
		
		socketChannel.pipeline().addLast(new ByteArrayEncoder());
		socketChannel.pipeline().addLast(packetEncoder);
		
		socketChannel.pipeline().addLast(eventExecutorGroup, channelFactory.getChannelHandler());
	}
}
