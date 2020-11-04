package pl.cwanix.opensun.db;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@SuppressWarnings("checkstyle:HideUtilityClassConstructor")
public class DBServerApplication {

    public static void main(final String[] args) {
        SpringApplication.run(DBServerApplication.class, args);
    }

}
