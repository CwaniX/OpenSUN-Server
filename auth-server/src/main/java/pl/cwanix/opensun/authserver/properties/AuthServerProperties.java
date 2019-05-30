package pl.cwanix.opensun.authserver.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.NestedConfigurationProperty;

import lombok.Getter;
import lombok.Setter;
import pl.cwanix.opensun.commonserver.properties.SUNServerProperties;

@Getter
@Setter
@ConfigurationProperties(prefix = "opensun")
public class AuthServerProperties extends SUNServerProperties {

	@NestedConfigurationProperty
	private AuthServerDBProperties db;
}
