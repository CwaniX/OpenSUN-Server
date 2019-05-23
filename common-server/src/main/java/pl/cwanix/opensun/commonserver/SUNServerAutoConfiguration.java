package pl.cwanix.opensun.commonserver;

import java.util.Map;
import java.util.function.BiFunction;

import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.socket.SocketChannel;
import io.netty.util.concurrent.DefaultEventExecutorGroup;
import io.netty.util.concurrent.EventExecutorGroup;
import pl.cwanix.opensun.commonserver.packets.ClientPacket;
import pl.cwanix.opensun.commonserver.properties.SUNServerProperties;
import pl.cwanix.opensun.commonserver.server.SUNServer;
import pl.cwanix.opensun.commonserver.server.SUNServerChannelHandlerFactory;
import pl.cwanix.opensun.commonserver.server.SUNServerChannelInitializer;
import pl.cwanix.opensun.commonserver.server.messages.PacketDecoder;
import pl.cwanix.opensun.commonserver.server.messages.PacketEncoder;
import pl.cwanix.opensun.utils.packets.PacketHeader;

@Configuration
@EnableConfigurationProperties(SUNServerProperties.class)
public class SUNServerAutoConfiguration {
	
	@Bean
	@ConditionalOnMissingBean
	public EventExecutorGroup eventExecutorGroup(SUNServerProperties properties) {
		return new DefaultEventExecutorGroup(properties.getMaxThreadCount());
	}
	
	@Bean
	@ConditionalOnMissingBean
	public PacketDecoder packetDecoder(Map<PacketHeader, BiFunction<byte[], byte[], ClientPacket>> clientPacketDefinitions) {
		return new PacketDecoder(clientPacketDefinitions);
	}
	
	@Bean
	@ConditionalOnMissingBean
	public PacketEncoder packetEncoder() {
		return new PacketEncoder();
	}
	
	@Bean
	@ConditionalOnMissingBean
	public ChannelInitializer<SocketChannel> sunServerChannelInitializer(EventExecutorGroup eventExecutorGroup, SUNServerChannelHandlerFactory sunServerChannelHandlerFactory, PacketDecoder packetDecoder, PacketEncoder packetEncoder) {
		return new SUNServerChannelInitializer(eventExecutorGroup, sunServerChannelHandlerFactory, packetDecoder, packetEncoder);
	}
	
	@Bean
	@ConditionalOnMissingBean
	public SUNServer sunServer(ChannelInitializer<SocketChannel> sunServerChannelHandler, SUNServerProperties properties) {		
		return new SUNServer(sunServerChannelHandler, properties);
	}
}
