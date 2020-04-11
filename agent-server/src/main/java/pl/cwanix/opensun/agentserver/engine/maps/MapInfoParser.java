package pl.cwanix.opensun.agentserver.engine.maps;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Marker;
import org.slf4j.MarkerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Service;
import pl.cwanix.opensun.agentserver.properties.AgentServerProperties;
import pl.cwanix.opensun.utils.files.SUNFileReader;

import java.io.IOException;
import java.io.Reader;
import java.util.HashMap;
import java.util.Map;

@Slf4j
@Service
@RequiredArgsConstructor
public class MapInfoParser implements InitializingBean {

	private static final Marker MARKER = MarkerFactory.getMarker("MAP INFO PARSER");

	private static final String FIELD_INFO_FILE_NAME = "field.txt";
	private static final String WORLD_INFO_FILE_NAME = "world.txt";

	private final AgentServerProperties properties;

	private Map<Integer, String> fieldInfo;
	private Map<Integer, MapInfo> mapInfo;

	private void loadFieldInfo() throws IOException {
		fieldInfo = new HashMap<>();

		try (SUNFileReader reader = new SUNFileReader(properties.getDataDirectory() + "/" + FIELD_INFO_FILE_NAME)) {
			while (reader.readLine()) {
				int index = reader.readNextIntValue();
				String value = reader.readNextStringValue();

				fieldInfo.put(index, value);
			}
		}

		log.info(MARKER, "Loaded field data: {}", fieldInfo.size());
	}

	private void loadMapInfo() throws IOException {
		mapInfo = new HashMap<>();

		try (SUNFileReader reader = new SUNFileReader(properties.getDataDirectory() + "/" + WORLD_INFO_FILE_NAME)) {
			while (reader.readLine()) {
				MapInfo map = new MapInfo();

				map.setMapCode(reader.readNextIntValue());
				map.setMapKind(reader.readNextIntValue());
				map.setMapKind(reader.readNextIntValue());
				map.setDebugName(reader.readNextStringValue());
				map.setNCode(reader.readNextIntValue());
				map.setDCode(reader.readNextIntValue());
				map.setMKind(reader.readNextIntValue());
				map.setMType(reader.readNextIntValue());
				map.setQCode(reader.readNextIntValue());
				map.setMinUserNum(reader.readNextIntValue());
				map.setMaxUserNum(reader.readNextIntValue());
				map.setMinLv(reader.readNextIntValue());
				map.setMaxLv(reader.readNextIntValue());
				map.setMapControlId(reader.readNextStringValue());
				map.setText1(reader.readNextIntValue());
				map.setText2(reader.readNextIntValue());
				map.setText3(reader.readNextIntValue());
			}
		}

		log.info(MARKER, "Loaded map data: {}", mapInfo.size());
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		//loadFieldInfo();
		//loadMapInfo();
	}
}
