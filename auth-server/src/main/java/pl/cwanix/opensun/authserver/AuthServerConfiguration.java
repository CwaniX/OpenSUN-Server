package pl.cwanix.opensun.authserver;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import pl.cwanix.opensun.authserver.properties.AuthServerProperties;

@Configuration
@PropertySource("file:${application.location}/config/auth-server.properties")
@EnableConfigurationProperties(AuthServerProperties.class)
public class AuthServerConfiguration {

}
