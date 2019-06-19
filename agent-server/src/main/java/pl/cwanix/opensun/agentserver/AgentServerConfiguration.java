package pl.cwanix.opensun.agentserver;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ClassPathScanningCandidateComponentProvider;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.type.filter.AnnotationTypeFilter;

import pl.cwanix.opensun.agentserver.properties.AgentServerProperties;
import pl.cwanix.opensun.commonserver.packets.IncomingPacket;
import pl.cwanix.opensun.commonserver.packets.Packet;
import pl.cwanix.opensun.utils.packets.PacketHeader;

@Configuration
@PropertySource("file:${application.location}/config/agent-server.properties")
@EnableConfigurationProperties(AgentServerProperties.class)
public class AgentServerConfiguration {
	
	@Bean
	public Map<PacketHeader, Function<byte[], Packet>> clientPacketDefinitions() throws Exception {
		ClassPathScanningCandidateComponentProvider classPathScanner = new ClassPathScanningCandidateComponentProvider(false);
		classPathScanner.addIncludeFilter(new AnnotationTypeFilter(IncomingPacket.class));
		
		Map<PacketHeader, Function<byte[], Packet>> definitions = new HashMap<>();
		
		for (BeanDefinition packetDefinition : classPathScanner.findCandidateComponents("pl.cwanix.opensun")) {
			Class<? extends Packet> packetClass = (Class<? extends Packet>) Class.forName(packetDefinition.getBeanClassName());
			
			Function<byte[], Packet> packetConstructorFunction = t -> {
				try {
					return packetClass.getConstructor(byte[].class).newInstance(t);
				} catch (InstantiationException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IllegalArgumentException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (InvocationTargetException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (NoSuchMethodException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SecurityException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				return null;
			};
			
			definitions.put((PacketHeader) packetClass.getDeclaredField("PACKET_ID").get(null), packetConstructorFunction);
		}
		
		return definitions;
	}
}
