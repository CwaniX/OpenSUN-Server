package pl.cwanix.opensun.authserver.communication;

import java.util.List;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import lombok.RequiredArgsConstructor;
import pl.cwanix.opensun.domain.ChannelDTO;
import pl.cwanix.opensun.domain.DataSourceConnector;
import pl.cwanix.opensun.domain.ServerDTO;
import pl.cwanix.opensun.authserver.properties.AuthServerProperties;
import pl.cwanix.opensun.domain.UserDTO;

@Service
@RequiredArgsConstructor
public class DatabaseProxyConnector implements DataSourceConnector {

    private final RestTemplate restTemplate;
    private final AuthServerProperties properties;

    public UserDTO findUser(final String userName) {
        return restTemplate.getForObject(properties.getDb().getServerUrl() + "/user/findByName?name=" + userName, UserDTO.class);
    }

    public int startAgentServerSession(final int userId) {
        return restTemplate.postForObject(properties.getAgent().getServerUrl() + "/session/new?userId=" + userId, null, Integer.class);
    }

    public List<ServerDTO> findServers() {
        return restTemplate.exchange(
                properties.getDb().getServerUrl() + "/server/findAll",
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<ServerDTO>>() { }).getBody();
    }

    public List<ChannelDTO> findChannels() {
        return restTemplate.exchange(properties.getDb().getServerUrl() + "/channel/findAll",
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<ChannelDTO>>() { }).getBody();
    }

    public ServerDTO findServer(final int serverId) {
        return restTemplate.getForObject(properties.getDb().getServerUrl() + "/server/findById?id=" + serverId,
                ServerDTO.class);
    }
}
