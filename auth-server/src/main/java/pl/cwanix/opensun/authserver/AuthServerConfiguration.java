package pl.cwanix.opensun.authserver;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import pl.cwanix.opensun.authserver.packet.c2s.C2SAskAuthPacket;
import pl.cwanix.opensun.authserver.packet.c2s.C2SAskSrvListPacket;
import pl.cwanix.opensun.authserver.packet.c2s.C2SAskSrvSelect;
import pl.cwanix.opensun.authserver.packet.c2s.C2SAskVerifyPacket;
import pl.cwanix.opensun.commonserver.packets.ClientPacket;
import pl.cwanix.opensun.utils.packets.PacketHeader;

@Configuration
public class AuthServerConfiguration {
	
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
