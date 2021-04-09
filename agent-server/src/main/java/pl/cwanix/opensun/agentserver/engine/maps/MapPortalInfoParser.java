package pl.cwanix.opensun.agentserver.engine.maps;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Marker;
import org.slf4j.MarkerFactory;
import org.springframework.stereotype.Service;
import pl.cwanix.opensun.agentserver.engine.maps.structures.PortalInfoStructure;
import pl.cwanix.opensun.agentserver.properties.AgentServerProperties;
import pl.cwanix.opensun.utils.files.SUNFileReader;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Slf4j
@Service
@RequiredArgsConstructor
public class MapPortalInfoParser {

    private static final Marker MARKER = MarkerFactory.getMarker("PORTAL INFO PARSER");

    private static final String PORTAL_INFO_FILE_NAME = "portal.txt"; // MapEnterancePortal.txt

    private final AgentServerProperties properties;

    public Map<Integer, PortalInfoStructure> loadPortalInfo() throws IOException {
        final Map<Integer, PortalInfoStructure> portalInfoStructureMap = new HashMap<>();

        try (SUNFileReader reader = new SUNFileReader(properties.getDataDirectory() + "/" + PORTAL_INFO_FILE_NAME)) {
            while (reader.readLine()) {
                PortalInfoStructure portal = new PortalInfoStructure();
                portal.setId(reader.readNextIntValue());
                portal.setMapType(reader.readNextByteValue());
                portal.setMoveType(reader.readNextByteValue());
                portal.setMapFrom(reader.readNextIntValue());
                portal.setFieldFrom(reader.readNextIntValue());
                portal.setAreaFrom(reader.readNextStringValue());
                portal.setMapTo(reader.readNextIntValue());
                portal.setFieldTo(reader.readNextIntValue());
                portal.setAreaTo(reader.readNextStringValue());
                portal.setMinLvl(reader.readNextIntValue());
                portal.setMaxLvl(reader.readNextIntValue());
                portal.setMissionCode(reader.readNextIntValue());
                portal.setQuestCode(reader.readNextIntValue());
                portal.setItemCode(reader.readNextIntValue());
                portal.setItemNum(reader.readNextByteValue());
                portal.setWasteItem(reader.readNextIntValue());
                portal.setHeim(reader.readNextIntValue());

                portalInfoStructureMap.put(portal.getId(), portal);
            }
        }

        log.info(MARKER, "Loaded portal data: {}", portalInfoStructureMap.size());

        return portalInfoStructureMap;
    }
}
