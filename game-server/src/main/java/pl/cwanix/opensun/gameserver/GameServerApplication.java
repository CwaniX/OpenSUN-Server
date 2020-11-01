package pl.cwanix.opensun.gameserver;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@SuppressWarnings("checkstyle:HideUtilityClassConstructor")
public class GameServerApplication {

    public static void main(final String[] args) {
        SpringApplication.run(GameServerApplication.class, args);
    }

}
