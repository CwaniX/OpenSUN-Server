package pl.cwanix.opensun.authserver;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.netty.util.concurrent.DefaultEventExecutorGroup;
import io.netty.util.concurrent.EventExecutorGroup;
import pl.cwanix.opensun.authserver.packet.c2s.C2SAskAuthPacket;
import pl.cwanix.opensun.authserver.packet.c2s.C2SAskSrvListPacket;
import pl.cwanix.opensun.authserver.packet.c2s.C2SAskSrvSelect;
import pl.cwanix.opensun.authserver.packet.c2s.C2SAskVerifyPacket;
import pl.cwanix.opensun.authserver.packet.c2s.ClientPacket;
import pl.cwanix.opensun.authserver.properties.AuthServerProperties;
import pl.cwanix.opensun.utils.packets.PacketHeader;

@Configuration
@EnableConfigurationProperties(AuthServerProperties.class)
public class AuthServerConfiguration {

	@Bean
	public EventExecutorGroup eventExecutorGroup(AuthServerProperties properties) {
		return new DefaultEventExecutorGroup(properties.getMaxThreadCount());
	}
	
	@Bean
	public Map<PacketHeader, BiFunction<byte[], byte[], ClientPacket>> clientPacketDefinitions() {
		Map<PacketHeader, BiFunction<byte[], byte[], ClientPacket>> definitions = new HashMap<>();
		definitions.put(C2SAskVerifyPacket.PACKET_ID, C2SAskVerifyPacket::new);
		definitions.put(C2SAskAuthPacket.PACKET_ID, C2SAskAuthPacket::new);
		definitions.put(C2SAskSrvListPacket.PACKET_ID, C2SAskSrvListPacket::new);
		definitions.put(C2SAskSrvSelect.PACKET_ID, C2SAskSrvSelect::new);
		
		return definitions;
	}
}
