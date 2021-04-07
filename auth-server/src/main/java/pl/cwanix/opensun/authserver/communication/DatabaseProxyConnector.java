package pl.cwanix.opensun.authserver.communication;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import pl.cwanix.opensun.authserver.properties.AuthServerProperties;

@Service
@RequiredArgsConstructor
public class DatabaseProxyConnector {

    private final RestTemplate restTemplate;
    private final AuthServerProperties properties;

    public int startAgentServerSession(final String userName) {
        return restTemplate.postForObject(properties.getAgent().getServerUrl() + "/session/new?userName=" + userName, null, Integer.class);
    }
}
