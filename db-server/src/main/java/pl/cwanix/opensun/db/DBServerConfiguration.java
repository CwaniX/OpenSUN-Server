package pl.cwanix.opensun.db;

import javax.annotation.PostConstruct;

import org.flywaydb.core.Flyway;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("file:${application.location}/config/db-server.properties")
public class DBServerConfiguration {

	@PostConstruct
	public void initializeDatabase() {
		Flyway flyway = Flyway.configure().load();
		
		
	}
}
