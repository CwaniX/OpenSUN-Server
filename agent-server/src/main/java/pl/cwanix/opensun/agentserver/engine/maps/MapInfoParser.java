package pl.cwanix.opensun.agentserver.engine.maps;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Service;
import pl.cwanix.opensun.agentserver.properties.AgentServerProperties;

import java.util.Map;

@Service
@RequiredArgsConstructor
public class MapInfoParser implements InitializingBean {

	private static final String FIELD_INFO_FILE_NAME = "field.csv";

	private final AgentServerProperties properties;

	private Map<Integer, String> fieldInfo;
	private Map<Integer, String> mapInfo;

	private void loadFieldInfo(String filePath) {

	}

	private void loadMapInfo(String filePath) {

	}

	@Override
	public void afterPropertiesSet() throws Exception {

	}
}
