package pl.cwanix.opensun.agentserver;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import pl.cwanix.opensun.agentserver.packets.c2s.C2SAskAuthPacket;
import pl.cwanix.opensun.commonserver.packets.ClientPacket;
import pl.cwanix.opensun.utils.packets.PacketHeader;

@Configuration
public class AgentServerConfiguration {
	
	@Bean
	public Map<PacketHeader, Function<byte[], ClientPacket>> clientPacketDefinitions() {
		Map<PacketHeader, Function<byte[], ClientPacket>> definitions = new HashMap<>();
		definitions.put(C2SAskAuthPacket.PACKET_ID, C2SAskAuthPacket::new); 
		
		return definitions;
	}
}
