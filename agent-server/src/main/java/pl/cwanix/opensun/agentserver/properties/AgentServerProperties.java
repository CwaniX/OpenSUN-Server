package pl.cwanix.opensun.agentserver.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@ConfigurationProperties
public class AgentServerProperties {

	private int port = 44406;
	private int maxQueueSize = 128;
	private int maxThreadCount = 2;
	private boolean epollMode = false;
	
}
