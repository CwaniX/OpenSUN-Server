package pl.cwanix.opensun.agentserver.engine.maps;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Marker;
import org.slf4j.MarkerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Service;
import pl.cwanix.opensun.agentserver.engine.experimental.maps.structures.FieldInfoStructure;
import pl.cwanix.opensun.agentserver.engine.experimental.maps.structures.MapInfoStructure;
import pl.cwanix.opensun.agentserver.properties.AgentServerProperties;
import pl.cwanix.opensun.utils.files.SUNFileReader;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Slf4j
@Getter
@Setter
@Service
@RequiredArgsConstructor
public class MapInfoParser implements InitializingBean {

    private static final Marker MARKER = MarkerFactory.getMarker("MAP INFO PARSER");

    private static final String FIELD_INFO_FILE_NAME = "field.txt";
    private static final String WORLD_INFO_FILE_NAME = "world.txt";

    private final AgentServerProperties properties;

    private Map<Integer, FieldInfoStructure> fieldInfoStructureMap;
    private Map<Integer, MapInfoStructure> mapInfoStructureMap;

    private void loadFieldInfo() throws IOException {
        fieldInfoStructureMap = new HashMap<>();

        try (SUNFileReader reader = new SUNFileReader(properties.getDataDirectory() + "/" + FIELD_INFO_FILE_NAME)) {
            while (reader.readLine()) {
                FieldInfoStructure field = new FieldInfoStructure();
                field.setFieldCode(reader.readNextIntValue());
                field.setPath(reader.readNextStringValue());

                fieldInfoStructureMap.put(field.getFieldCode(), field);
            }
        }

        log.info(MARKER, "Loaded field data: {}", fieldInfoStructureMap.size());
    }

    private void loadMapInfo() throws IOException {
        mapInfoStructureMap = new HashMap<>();

        try (SUNFileReader reader = new SUNFileReader(properties.getDataDirectory() + "/" + WORLD_INFO_FILE_NAME)) {
            while (reader.readLine()) {
                MapInfoStructure map = new MapInfoStructure();

                map.setMapCode(reader.readNextIntValue());
                map.setMapKind(reader.readNextIntValue());
                map.setMName(reader.readNextStringValue());
                map.setNCode(reader.readNextIntValue());
                map.setFnCode(reader.readNextIntValue());
                map.setDCode(reader.readNextIntValue());
                map.setAnCode(reader.readNextIntValue());
                map.setGuildEnt(reader.readNextIntValue());
                map.setGuildItem(reader.readNextIntValue());
                map.setTimeLim(reader.readNextIntValue());
                map.setMKind(reader.readNextIntValue());
                map.setMType(reader.readNextIntValue());
                map.setMinUser(reader.readNextIntValue());
                map.setMaxUser(reader.readNextIntValue());
                map.setMinLv(reader.readNextIntValue());
                map.setMaxLv(reader.readNextIntValue());
                map.setFreePassLv(reader.readNextIntValue());
                map.setStartId(reader.readNextStringValue());
                map.setStartId2(reader.readNextStringValue());
                map.setEntCount(reader.readNextIntValue());
                map.setClass1(reader.readNextIntValue());
                map.setFCount(reader.readNextIntValue());
                map.setCompleteQCode(reader.readNextIntValue());
                map.setCompleteMCode(reader.readNextIntValue());
                map.setContinentCode(reader.readNextIntValue());

                map.setMMap(new byte[MapInfoStructure.MAX_FIELD_NUMBER]);
                map.setPMap(new int[MapInfoStructure.MAX_FIELD_NUMBER]);
                map.setCMap(new int[MapInfoStructure.MAX_FIELD_NUMBER]);

                for (int i = 0; i < MapInfoStructure.MAX_FIELD_NUMBER; i++) {
                    map.getMMap()[i] = reader.readNextByteValue();
                }

                for (int i = 0; i < MapInfoStructure.MAX_FIELD_NUMBER; i++) {
                    map.getPMap()[i] = reader.readNextIntValue();
                }

                for (int i = 0; i < MapInfoStructure.MAX_FIELD_NUMBER; i++) {
                    map.getCMap()[i] = reader.readNextIntValue();
                }

                mapInfoStructureMap.put(map.getMapCode(), map);
            }
        }

        log.info(MARKER, "Loaded map data: {}", mapInfoStructureMap.size());
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        loadFieldInfo();
        loadMapInfo();
    }
}
