package pl.cwanix.opensun.agentserver;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import pl.cwanix.opensun.agentserver.packets.c2s.C2SAskAuthPacket;
import pl.cwanix.opensun.agentserver.packets.c2s.C2SAskCreateNewCharPacket;
import pl.cwanix.opensun.agentserver.packets.c2s.C2SAskDeleteCharPacket;
import pl.cwanix.opensun.agentserver.packets.c2s.C2SAskFreeCharNamePacket;
import pl.cwanix.opensun.agentserver.packets.c2s.C2SAskPingPacket;
import pl.cwanix.opensun.agentserver.properties.AgentServerProperties;
import pl.cwanix.opensun.commonserver.packets.ClientPacket;
import pl.cwanix.opensun.utils.packets.PacketHeader;

@Configuration
@PropertySource("file:${application.location}/config/agent-server.properties")
@EnableConfigurationProperties(AgentServerProperties.class)
public class AgentServerConfiguration {
	
	@Bean
	public Map<PacketHeader, Function<byte[], ClientPacket>> clientPacketDefinitions() {
		Map<PacketHeader, Function<byte[], ClientPacket>> definitions = new HashMap<>();
		definitions.put(C2SAskAuthPacket.PACKET_ID, C2SAskAuthPacket::new); 
		definitions.put(C2SAskFreeCharNamePacket.PACKET_ID, C2SAskFreeCharNamePacket::new);
		definitions.put(C2SAskPingPacket.PACKET_ID, C2SAskPingPacket::new);
		definitions.put(C2SAskDeleteCharPacket.PACKET_ID, C2SAskDeleteCharPacket::new);
		definitions.put(C2SAskCreateNewCharPacket.PACKET_ID, C2SAskCreateNewCharPacket::new);
		
		return definitions;
	}
}
