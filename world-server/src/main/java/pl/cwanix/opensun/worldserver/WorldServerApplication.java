package pl.cwanix.opensun.worldserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@SuppressWarnings("checkstyle:HideUtilityClassConstructor")
public class WorldServerApplication {

    public static void main(final String[] args) {
        SpringApplication.run(WorldServerApplication.class, args);
    }

}
