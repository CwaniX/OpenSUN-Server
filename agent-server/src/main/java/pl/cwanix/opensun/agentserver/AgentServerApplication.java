package pl.cwanix.opensun.agentserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@SuppressWarnings("checkstyle:HideUtilityClassConstructor")
public class AgentServerApplication {

    public static void main(final String[] args) {
        SpringApplication.run(AgentServerApplication.class, args);
    }

}
