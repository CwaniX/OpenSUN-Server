package pl.cwanix.opensun.agentserver.controllers;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import pl.cwanix.opensun.agentserver.entities.UserEntity;
import pl.cwanix.opensun.agentserver.properties.AgentServerProperties;
import pl.cwanix.opensun.agentserver.server.session.AgentServerSessionManager;

@Slf4j
@RestController
@RequestMapping("/session")
@RequiredArgsConstructor
public class AuthController {
	
	private final RestTemplate restTemplate;
	private final AgentServerSessionManager sessionManager;
	private final AgentServerProperties properties;
	
	@PostMapping(path = "/new", produces = "application/json")
	public Integer create(@RequestParam("userId") int userId) {
		UserEntity user = restTemplate.getForObject("http://" + properties.getDb().getIp() + ":" + properties.getDb().getPort() + "/user/findById?id=" + userId, UserEntity.class);
		
		if (user == null) {
			log.debug("Unable to start session for userId: {}", userId);
			return 1;
		} else {
			log.debug("Starting new session for user: {} with id: {}", user.getName(), user.getId());
			sessionManager.startNewSession(user);
		}

		return 0;
	}

}
