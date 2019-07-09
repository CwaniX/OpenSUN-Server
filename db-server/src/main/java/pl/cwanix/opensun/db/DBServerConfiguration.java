package pl.cwanix.opensun.db;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.flywaydb.core.Flyway;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import lombok.RequiredArgsConstructor;

@Configuration
@RequiredArgsConstructor
@PropertySource("file:${application.location}/config/db-server.properties")
public class DBServerConfiguration {
	
	private final DataSource dataSource;

	@PostConstruct
	public void initializeDatabase() {
		Flyway.configure().dataSource(dataSource).schemas("public").locations("classpath:db/public").table("schema_history").load().migrate();
		Flyway.configure().dataSource(dataSource).schemas("config").locations("classpath:db/config").table("schema_history").load().migrate();
	}
}
