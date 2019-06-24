package pl.cwanix.opensun.worldserver;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import pl.cwanix.opensun.worldserver.properties.WorldServerProperties;

@Configuration
@PropertySource("file:${application.location}/config/world-server.properties")
@EnableConfigurationProperties(WorldServerProperties.class)
public class WorldServerConfiguration {

}
