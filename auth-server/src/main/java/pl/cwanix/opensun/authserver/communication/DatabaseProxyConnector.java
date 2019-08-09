package pl.cwanix.opensun.authserver.communication;

import java.util.List;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import lombok.RequiredArgsConstructor;
import pl.cwanix.opensun.authserver.entities.ServerEntity;
import pl.cwanix.opensun.authserver.entities.UserEntity;
import pl.cwanix.opensun.authserver.properties.AuthServerProperties;

@Service
@RequiredArgsConstructor
public class DatabaseProxyConnector {

	private final RestTemplate restTemplate;
	private final AuthServerProperties properties;
	
	public UserEntity findUser(String userName) {
		return restTemplate.getForObject(properties.getDb().getServerUrl() + "/user/findByName?name=" + userName, UserEntity.class);
	}
	
	public int startAgentServerSession(int userId) {
		return restTemplate.postForObject(properties.getAgent().getServerUrl() + "/session/new?userId=" + userId, null, Integer.class);
	}
	
	public List<ServerEntity> findServers() {
		return restTemplate.exchange(properties.getDb().getServerUrl() + "/server/findAll", HttpMethod.GET, null, new ParameterizedTypeReference<List<ServerEntity>>(){}).getBody();
	}
}
