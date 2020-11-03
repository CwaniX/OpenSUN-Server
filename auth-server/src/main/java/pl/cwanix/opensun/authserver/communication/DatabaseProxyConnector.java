package pl.cwanix.opensun.authserver.communication;

import java.util.List;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import lombok.RequiredArgsConstructor;
import pl.cwanix.opensun.model.server.ChannelModel;
import pl.cwanix.opensun.model.server.ServerDataSource;
import pl.cwanix.opensun.model.server.ServerModel;
import pl.cwanix.opensun.authserver.properties.AuthServerProperties;
import pl.cwanix.opensun.model.account.UserModel;

@Service
@RequiredArgsConstructor
public class DatabaseProxyConnector implements ServerDataSource {

    private final RestTemplate restTemplate;
    private final AuthServerProperties properties;

    public UserModel findUser(final String userName) {
        return restTemplate.getForObject(properties.getDb().getServerUrl() + "/user/findByName?name=" + userName, UserModel.class);
    }

    public int startAgentServerSession(final int userId) {
        return restTemplate.postForObject(properties.getAgent().getServerUrl() + "/session/new?userId=" + userId, null, Integer.class);
    }

    @Override
    public List<ServerModel> findServers() {
        return restTemplate.exchange(
                properties.getDb().getServerUrl() + "/server/findAll",
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<ServerModel>>() { }).getBody();
    }

    @Override
    public List<ChannelModel> findChannels() {
        return restTemplate.exchange(properties.getDb().getServerUrl() + "/channel/findAll",
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<ChannelModel>>() { }).getBody();
    }

    @Override
    public ServerModel findServer(final int serverId) {
        return restTemplate.getForObject(properties.getDb().getServerUrl() + "/server/findById?id=" + serverId,
                ServerModel.class);
    }
}
