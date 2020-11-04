package pl.cwanix.opensun.authserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@SuppressWarnings("checkstyle:HideUtilityClassConstructor")
public class AuthServerApplication {

    public static void main(final String[] args) {
        SpringApplication.run(AuthServerApplication.class, args);
    }

}

