package pl.cwanix.opensun.agentserver.controllers;

import org.slf4j.Marker;
import org.slf4j.MarkerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import pl.cwanix.opensun.model.account.UserModel;
import pl.cwanix.opensun.agentserver.properties.AgentServerProperties;
import pl.cwanix.opensun.agentserver.server.session.AgentServerSessionManager;

@Slf4j
@RestController
@RequestMapping("/session")
@RequiredArgsConstructor
public class AuthController {

    private static final Marker MARKER = MarkerFactory.getMarker("AUTH CONTROLLER");

    private final RestTemplate restTemplate;
    private final AgentServerSessionManager sessionManager;
    private final AgentServerProperties properties;

    @PostMapping(path = "/new", produces = "application/json")
    public Integer create(@RequestParam("userId") final int userId) {
        log.info(MARKER, "Starting new session for user with id: {}", userId);

        UserModel user = restTemplate.getForObject("http://" + properties.getDb().getIp() + ":" + properties.getDb().getPort() + "/user/findById?id=" + userId, UserModel.class);

        if (user == null) {
            log.error(MARKER, "Unable to start session for user with id: {}", userId);
            return 1;
        } else {
            sessionManager.startNewSession(user);
        }

        return 0;
    }

}
