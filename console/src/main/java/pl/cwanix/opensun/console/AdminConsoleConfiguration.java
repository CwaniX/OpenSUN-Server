package pl.cwanix.opensun.console;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import lombok.RequiredArgsConstructor;

@Configuration
@RequiredArgsConstructor
@PropertySource("file:${application.location}/config/console-server.properties")
public class AdminConsoleConfiguration {

}
