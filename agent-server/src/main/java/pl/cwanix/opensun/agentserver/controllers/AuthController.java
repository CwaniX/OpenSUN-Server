package pl.cwanix.opensun.agentserver.controllers;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Marker;
import org.slf4j.MarkerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pl.cwanix.opensun.agentserver.server.session.AgentServerSessionManager;
import pl.cwanix.opensun.model.account.AccountDataSource;
import pl.cwanix.opensun.model.account.UserModel;

@Slf4j
@RestController
@RequestMapping("/session")
@RequiredArgsConstructor
public class AuthController {

    private static final Marker MARKER = MarkerFactory.getMarker("AUTH CONTROLLER");

    private final AccountDataSource accountDataSource;
    private final AgentServerSessionManager sessionManager;

    @PostMapping(path = "/new", produces = "application/json")
    public Integer create(@RequestParam("userName") final String userName) {
        log.info(MARKER, "Starting new session for user with name: {}", userName);

        final UserModel user = accountDataSource.findUser(userName);

        if (user == null) {
            log.error(MARKER, "Unable to start session for user with name: {}", userName);
            return 1;
        } else {
            sessionManager.startNewSession(user);
        }

        return 0;
    }

}
