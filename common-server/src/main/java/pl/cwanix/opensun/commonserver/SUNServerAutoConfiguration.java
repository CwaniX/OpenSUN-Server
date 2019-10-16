package pl.cwanix.opensun.commonserver;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.socket.SocketChannel;
import io.netty.util.concurrent.DefaultEventExecutorGroup;
import io.netty.util.concurrent.EventExecutorGroup;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Marker;
import org.slf4j.MarkerFactory;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
import pl.cwanix.opensun.commonserver.packets.Packet;
import pl.cwanix.opensun.commonserver.properties.SUNServerProperties;
import pl.cwanix.opensun.commonserver.server.SUNServer;
import pl.cwanix.opensun.commonserver.server.SUNServerChannelHandlerFactory;
import pl.cwanix.opensun.commonserver.server.SUNServerChannelInitializer;
import pl.cwanix.opensun.commonserver.server.messages.PacketDecoder;
import pl.cwanix.opensun.commonserver.server.messages.PacketEncoder;
import pl.cwanix.opensun.utils.datatypes.PacketHeader;
import pl.cwanix.opensun.utils.functions.ThrowingFunction;

import java.util.Map;

@Slf4j
@Configuration
@ComponentScan
public class SUNServerAutoConfiguration {
	
	private static final Marker MARKER = MarkerFactory.getMarker("SUN SERVER");
	
	@Bean
	@ConditionalOnMissingBean
	public EventExecutorGroup eventExecutorGroup(SUNServerProperties properties) {
		return new DefaultEventExecutorGroup(properties.getClient().getMaxThreadCount());
	}
	
	@Bean
	@ConditionalOnMissingBean
	public PacketDecoder packetDecoder(Map<PacketHeader, ThrowingFunction<byte[], Packet, Exception>> clientPacketDefinitions, RestTemplate restTemplate) {
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
	
	@Bean
	@ConditionalOnMissingBean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		return builder.build();
	}
}
