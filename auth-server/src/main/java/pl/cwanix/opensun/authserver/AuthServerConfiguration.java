package pl.cwanix.opensun.authserver;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import pl.cwanix.opensun.authserver.packet.c2s.C2SAskAuthPacket;
import pl.cwanix.opensun.authserver.packet.c2s.C2SAskSrvListPacket;
import pl.cwanix.opensun.authserver.packet.c2s.C2SAskSrvSelect;
import pl.cwanix.opensun.authserver.packet.c2s.C2SAskVerifyPacket;
import pl.cwanix.opensun.authserver.properties.AuthServerProperties;
import pl.cwanix.opensun.commonserver.packets.ClientPacket;
import pl.cwanix.opensun.utils.packets.PacketHeader;

@Configuration
@PropertySource("file:${application.location}/config/auth-server.properties")
@EnableConfigurationProperties(AuthServerProperties.class)
public class AuthServerConfiguration {

	@Bean
	public Map<PacketHeader, Function<byte[], ClientPacket>> clientPacketDefinitions() {
		Map<PacketHeader,Function<byte[], ClientPacket>> definitions = new HashMap<>();
		definitions.put(C2SAskVerifyPacket.PACKET_ID, C2SAskVerifyPacket::new);
		definitions.put(C2SAskAuthPacket.PACKET_ID, C2SAskAuthPacket::new);
		definitions.put(C2SAskSrvListPacket.PACKET_ID, C2SAskSrvListPacket::new);
		definitions.put(C2SAskSrvSelect.PACKET_ID, C2SAskSrvSelect::new);

		return definitions;
	}
}
