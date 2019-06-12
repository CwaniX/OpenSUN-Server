package pl.cwanix.opensun.commonserver.server;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.slf4j.Marker;
import org.slf4j.MarkerFactory;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.buffer.PooledByteBufAllocator;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.ServerChannel;
import io.netty.channel.epoll.EpollEventLoopGroup;
import io.netty.channel.epoll.EpollServerSocketChannel;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.logging.LogLevel;
import io.netty.handler.logging.LoggingHandler;
import io.netty.util.internal.logging.InternalLoggerFactory;
import io.netty.util.internal.logging.Slf4JLoggerFactory;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import pl.cwanix.opensun.commonserver.properties.SUNServerProperties;

@Slf4j
@RequiredArgsConstructor
public class SUNServer {
	
	private static final Marker MARKER = MarkerFactory.getMarker("SUN SERVER");

	private EventLoopGroup parentGroup = new NioEventLoopGroup();
	private EventLoopGroup childGroup = new NioEventLoopGroup();

	private final ChannelInitializer<SocketChannel> sunServerChannelInitializer;
	private final SUNServerProperties properties;

	@PostConstruct
	public void startServer() throws InterruptedException {
		setupLoopGroups();

		log.info(MARKER, "Starting server");

		InternalLoggerFactory.setDefaultFactory(Slf4JLoggerFactory.INSTANCE);

		ServerBootstrap serverBootstrap = new ServerBootstrap();
		serverBootstrap.group(parentGroup, childGroup).channel(setupServerSocketChannel()).handler(setupLoggingHander())
				.childHandler(sunServerChannelInitializer)
				.option(ChannelOption.SO_BACKLOG, properties.getClient().getMaxQueueSize())
				.childOption(ChannelOption.SO_KEEPALIVE, true)
				.childOption(ChannelOption.ALLOCATOR, PooledByteBufAllocator.DEFAULT);

		try {
			serverBootstrap.bind(properties.getClient().getPort()).sync();
		} catch (Exception e) {

		}

	}

	private void setupLoopGroups() {
		if (properties.getClient().isEpollMode()) {
			parentGroup = new EpollEventLoopGroup();
			childGroup = new EpollEventLoopGroup(properties.getClient().getMaxThreadCount());
		} else {
			parentGroup = new NioEventLoopGroup();
			childGroup = new NioEventLoopGroup(properties.getClient().getMaxThreadCount());
		}
	}

	private Class<? extends ServerChannel> setupServerSocketChannel() {
		if (properties.getClient().isEpollMode()) {
			return EpollServerSocketChannel.class;
		} else {
			return NioServerSocketChannel.class;
		}
	}

	private ChannelHandler setupLoggingHander() {
		return new LoggingHandler(LogLevel.INFO);
	}

	@PreDestroy
	public void stopServer() {
		log.info(MARKER, "Stopping server");
		childGroup.shutdownGracefully();
		parentGroup.shutdownGracefully();
	}
}
