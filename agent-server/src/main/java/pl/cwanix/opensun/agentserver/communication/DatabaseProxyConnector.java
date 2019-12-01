package pl.cwanix.opensun.agentserver.communication;

import java.util.List;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import lombok.RequiredArgsConstructor;
import pl.cwanix.opensun.agentserver.entities.CharacterEntity;
import pl.cwanix.opensun.agentserver.properties.AgentServerProperties;

@Service
@RequiredArgsConstructor
public class DatabaseProxyConnector {

	private final RestTemplate restTemplate;
	private final AgentServerProperties properties;
	
	public int createCharacter(int accountId, String charName, int classCode, int heightCode, int faceCode, int hairCode, int slot) {
		return restTemplate.postForObject(properties.getDb().getServerUrl()
				+ "/character/create?accountId=" + accountId
				+ "&name=" + charName
				+ "&classCode=" + classCode
				+ "&heightCode=" + heightCode
				+ "&faceCode=" + faceCode
				+ "&hairCode=" + hairCode
				+ "&slot=" + slot, null, Integer.class);
	}
	
	public void deleteCharacter(int userId, int slot) {
		restTemplate.delete(properties.getDb().getServerUrl() + "/character/delete?accountId=" + userId + "&slot=" + slot);
	}
	
	public CharacterEntity findCharacter(int accountId, int slot) {
		return restTemplate.getForObject(properties.getDb().getServerUrl()
				+ "/character/findByAccountIdAndSlot?accountId=" + accountId
				+ "&slot=" + slot, CharacterEntity.class);
	}
	
	public List<CharacterEntity> findCharactersList(int accountId) {
		return restTemplate.exchange(properties.getDb().getServerUrl() + "/character/findByAccountId?accountId=" + accountId, HttpMethod.GET, null, new ParameterizedTypeReference<List<CharacterEntity>>(){}).getBody();
	}
	
	public int findFreeSlot(int userId) {
		return restTemplate.getForObject(properties.getDb().getServerUrl() + "/character/findFreeSlotByAccountId?accountId=" + userId,Integer.class);
	}
	
	public int updateCharacterPosition(int characterId, float x, float y, float z, int angle) {
		return restTemplate.postForObject(properties.getDb().getServerUrl()
				+ "/character/updatePosition?id=" + characterId
				+ "&x=" + x
				+ "&y=" + y
				+ "&z=" + z
				+ "&angle=" + angle, null, Integer.class);
	}
	
	public int updateCharacterStatistics(int characterId, byte attributeCode) {
		return restTemplate.postForObject(properties.getDb().getServerUrl()
				+ "/character/updateStatistics?id=" + characterId
				+ "&attributeCode=" + attributeCode, null, Integer.class);
	}
}
