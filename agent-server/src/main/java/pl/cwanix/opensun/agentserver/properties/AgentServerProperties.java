package pl.cwanix.opensun.agentserver.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.NestedConfigurationProperty;

import lombok.Getter;
import lombok.Setter;
import pl.cwanix.opensun.commonserver.properties.SUNServerExternalServerProperties;
import pl.cwanix.opensun.commonserver.properties.SUNServerProperties;

@Getter
@Setter
@ConfigurationProperties(prefix = "opensun")
public class AgentServerProperties extends SUNServerProperties {

	@NestedConfigurationProperty
	private SUNServerExternalServerProperties db;
	
	@NestedConfigurationProperty
	private SUNServerExternalServerProperties world;

	private String dataDirectory;
}
