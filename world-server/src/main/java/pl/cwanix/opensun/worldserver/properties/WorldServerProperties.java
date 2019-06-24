package pl.cwanix.opensun.worldserver.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;

import lombok.Getter;
import lombok.Setter;
import pl.cwanix.opensun.commonserver.properties.SUNServerProperties;

@Getter
@Setter
@ConfigurationProperties(prefix = "opensun")
public class WorldServerProperties extends SUNServerProperties {

}
