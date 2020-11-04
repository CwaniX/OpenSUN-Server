package pl.cwanix.opensun.gameserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@SuppressWarnings("checkstyle:HideUtilityClassConstructor")
public class GameServerApplication {

    public static void main(final String[] args) {
        SpringApplication.run(GameServerApplication.class, args);
    }

}
