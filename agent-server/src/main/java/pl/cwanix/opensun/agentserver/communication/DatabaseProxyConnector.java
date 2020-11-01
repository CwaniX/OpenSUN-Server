package pl.cwanix.opensun.agentserver.communication;

import lombok.RequiredArgsConstructor;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import pl.cwanix.opensun.agentserver.properties.AgentServerProperties;
import pl.cwanix.opensun.domain.CharacterDTO;
import pl.cwanix.opensun.domain.DataSourceConnector;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DatabaseProxyConnector implements DataSourceConnector {

    private final RestTemplate restTemplate;
    private final AgentServerProperties properties;

    public int createCharacter(
            final int accountId,
            final String charName,
            final int classCode,
            final int heightCode,
            final int faceCode,
            final int hairCode,
            final int slot
    ) {
        return restTemplate.postForObject(properties.getDb().getServerUrl()
                + "/character/create?accountId=" + accountId
                + "&name=" + charName
                + "&classCode=" + classCode
                + "&heightCode=" + heightCode
                + "&faceCode=" + faceCode
                + "&hairCode=" + hairCode
                + "&slot=" + slot, null, Integer.class);
    }

    public void deleteCharacter(final int userId, final int slot) {
        restTemplate.delete(properties.getDb().getServerUrl() + "/character/delete?accountId=" + userId + "&slot=" + slot);
    }

    public CharacterDTO findCharacter(final int accountId, final int slot) {
        return restTemplate.getForObject(properties.getDb().getServerUrl()
                + "/character/findByAccountIdAndSlot?accountId=" + accountId
                + "&slot=" + slot, CharacterDTO.class);
    }

    public List<CharacterDTO> findCharactersList(final int accountId) {
        return restTemplate.exchange(properties.getDb().getServerUrl()
                + "/character/findByAccountId?accountId="
                + accountId, HttpMethod.GET, null, new ParameterizedTypeReference<List<CharacterDTO>>() { }).getBody();
    }

    public int findFreeSlot(final int userId) {
        return restTemplate.getForObject(properties.getDb().getServerUrl() + "/character/findFreeSlotByAccountId?accountId=" + userId, Integer.class);
    }

    public int updateCharacterPosition(final int characterId, final float x, final float y, final float z, final int angle) {
        return restTemplate.postForObject(properties.getDb().getServerUrl()
                + "/character/updatePosition?id=" + characterId
                + "&x=" + x
                + "&y=" + y
                + "&z=" + z
                + "&angle=" + angle, null, Integer.class);
    }

    public int updateCharacterStatistics(final int characterId, final byte attributeCode) {
        return restTemplate.postForObject(properties.getDb().getServerUrl()
                + "/character/updateStatistics?id=" + characterId
                + "&attributeCode=" + attributeCode, null, Integer.class);
    }
}
