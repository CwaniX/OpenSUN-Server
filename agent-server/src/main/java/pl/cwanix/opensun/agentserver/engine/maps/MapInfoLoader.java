package pl.cwanix.opensun.agentserver.engine.maps;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Service;
import pl.cwanix.opensun.agentserver.engine.maps.objects.FieldInfo;
import pl.cwanix.opensun.agentserver.engine.maps.objects.MapInfo;
import pl.cwanix.opensun.agentserver.engine.maps.structures.MapInfoStructure;

import java.util.Map;

@Slf4j
@Getter
@Setter
@Service
@RequiredArgsConstructor
public class MapInfoLoader implements InitializingBean {

	private final MapInfoParser mapInfoParser;

	private Map<Integer, FieldInfo> fieldInfo;
	private Map<Integer, MapInfo> mapInfo;

	private void loadMapInfo() {
		Map<Integer, MapInfoStructure> mapInfoStructures = mapInfoParser.getMapInfo();

		for (MapInfoStructure structure : mapInfoStructures.values()) {

		}
	}

	@Override
	public void afterPropertiesSet() throws Exception {

	}
}
