package pl.cwanix.opensun.agentserver;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import pl.cwanix.opensun.agentserver.properties.AgentServerProperties;

@Configuration
@PropertySource("file:${application.location}/config/agent-server.properties")
@EnableConfigurationProperties(AgentServerProperties.class)
public class AgentServerConfiguration {

}
