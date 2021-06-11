package pl.cwanix.opensun.agentserver.engine.npc;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Marker;
import org.slf4j.MarkerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Service;
import pl.cwanix.opensun.agentserver.engine.npc.structures.NpcInfoStructure;
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
public class NpcInfoParser implements InitializingBean {

    private static final Marker MARKER = MarkerFactory.getMarker("NPC INFO PARSER");

    private static final String NPC_INFO_FILE_NAME = "npcinfo.txt";

    private final AgentServerProperties properties;

    private Map<Integer, NpcInfoStructure> npcInfoStructureMap;

    private void loadNpcInfo() throws IOException {
        npcInfoStructureMap = new HashMap<>();

        try (SUNFileReader reader = new SUNFileReader(properties.getDataDirectory() + "/" + NPC_INFO_FILE_NAME)) {
            while (reader.readLine()) {
                NpcInfoStructure field = new NpcInfoStructure();
                field.setMonsterCode(reader.readNextIntValue());
                field.setName(reader.readNextStringValue());
                field.setLevel(reader.readNextIntValue());

                npcInfoStructureMap.put(field.getMonsterCode(), field);
            }
        }

        log.info(MARKER, "Loaded npc data: {}", npcInfoStructureMap.size());
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        loadNpcInfo();
    }
}
