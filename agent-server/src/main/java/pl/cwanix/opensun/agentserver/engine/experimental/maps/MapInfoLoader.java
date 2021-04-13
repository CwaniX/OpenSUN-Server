package pl.cwanix.opensun.agentserver.engine.experimental.maps;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Marker;
import org.slf4j.MarkerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import pl.cwanix.opensun.agentserver.engine.experimental.maps.objects.FieldInfo;
import pl.cwanix.opensun.agentserver.engine.experimental.maps.objects.MapInfo;
import pl.cwanix.opensun.agentserver.engine.experimental.maps.structures.FieldInfoStructure;
import pl.cwanix.opensun.agentserver.engine.experimental.maps.structures.MapInfoStructure;
import pl.cwanix.opensun.agentserver.engine.maps.MapInfoParser;
import pl.cwanix.opensun.agentserver.properties.AgentServerProperties;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@Slf4j
@Getter
@Setter
@Service
@Profile("experimental")
@RequiredArgsConstructor
public class MapInfoLoader implements InitializingBean {

    private static final Marker MARKER = MarkerFactory.getMarker("MAP INFO LOADER");

    private static final int VILLAGE_SECTOR_SIZE = 0;
    private static final int ROOM_SECTOR_SIZE = 0;

    private final MapInfoParser mapInfoParser;
    private final AgentServerProperties properties;

    private Map<Integer, MapInfo> mapInfoMap;

    private void loadMapInfo() {
        mapInfoMap = new HashMap<>();

        Map<Integer, MapInfoStructure> mapInfoStructureMap = mapInfoParser.getMapInfoStructureMap();

        for (MapInfoStructure structure : mapInfoStructureMap.values()) {
            int sectorSize = ROOM_SECTOR_SIZE;
            boolean viewport = false;

            if (ZoneType.VILLAGE.equals(structure.getMKind())) {
                sectorSize = VILLAGE_SECTOR_SIZE;
                viewport = true;
            }

            final FieldInfoStructure fieldInfoStructure = mapInfoParser.getFieldInfoStructureMap().get(structure.getMapCode());

            if (Objects.nonNull(fieldInfoStructure)) {
                final FieldInfo fieldInfo = new FieldInfo(fieldInfoStructure);
                fieldInfo.load(properties.getDataDirectory());
                fieldInfo.establishSectorInfo(sectorSize, viewport);

                final MapInfo mapInfo = new MapInfo(structure, fieldInfo);

                mapInfoMap.put(mapInfo.getMapInfoStructure().getMapCode(), mapInfo);
            } else {
                log.warn(MARKER, "No field for map code: {}", structure.getMapCode());
            }
        }
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        loadMapInfo();
    }
}
