package pl.cwanix.opensun.agentserver;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.netty.util.concurrent.DefaultEventExecutorGroup;
import io.netty.util.concurrent.EventExecutorGroup;
import pl.cwanix.opensun.agentserver.properties.AgentServerProperties;

@Configuration
@EnableConfigurationProperties(AgentServerProperties.class)
public class AgentServerConfiguration {

	@Bean
	public EventExecutorGroup eventExecutorGroup(AgentServerProperties properties) {
		return new DefaultEventExecutorGroup(properties.getMaxThreadCount());
	}
	
}
