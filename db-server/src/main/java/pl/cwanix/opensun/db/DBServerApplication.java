package pl.cwanix.opensun.db;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@PropertySource("file:${application.location}/config/db-server.properties")
public class DBServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(DBServerApplication.class, args);
	}

}
