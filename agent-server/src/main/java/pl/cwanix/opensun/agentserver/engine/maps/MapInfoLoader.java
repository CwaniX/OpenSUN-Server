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
import pl.cwanix.opensun.agentserver.properties.AgentServerProperties;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@Slf4j
@Getter
@Setter
@Service
@RequiredArgsConstructor
public class MapInfoLoader implements InitializingBean {

	private static final int VILLAGE_SECTOR_SIZE = 0;
	private static final int ROOM_SECTOR_SIZE = 0;

	private final MapInfoParser mapInfoParser;
	private final AgentServerProperties properties;

	private Map<Integer, FieldInfo> fieldInfoMap;
	private Map<Integer, MapInfo> mapInfoMap;

	private void loadMapInfo() {
		fieldInfoMap = new HashMap<>();
		mapInfoMap = new HashMap<>();

		Map<Integer, MapInfoStructure> mapInfoStructureMap = mapInfoParser.getMapInfoStructureMap();

		for (MapInfoStructure structure : mapInfoStructureMap.values()) {
			MapInfo mapInfo = new MapInfo(structure);
			int sectorSize = ROOM_SECTOR_SIZE;
			boolean viewport = false;

			if (ZoneType.VILLAGE.equals(structure.getMKind())) {
				sectorSize = VILLAGE_SECTOR_SIZE;
				viewport = true;
			}

			for (int i = 0; i < MapInfoStructure.MAX_FIELD_NUMBER; i++) {
				if (structure.getFCode()[i] != 0) {
					FieldInfo fieldInfo = fieldInfoMap.get(structure.getFCode()[i]);

					if (Objects.isNull(fieldInfo)) {
						fieldInfo = new FieldInfo(mapInfoParser.getFieldInfoStructureMap().get(structure.getFCode()[i]));
						fieldInfo.load(properties.getDataDirectory());
						fieldInfo.establishSectorInfo(sectorSize, viewport);

						fieldInfoMap.put(structure.getFCode()[i], fieldInfo);
					}

					mapInfo.getFieldInfoMap().put(0, fieldInfo);
				}
			}

			mapInfoMap.put(mapInfo.getMapInfoStructure().getMapCode(), mapInfo);
		}
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		loadMapInfo();
	}
}
