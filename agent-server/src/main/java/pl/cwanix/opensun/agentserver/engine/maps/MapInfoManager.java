package pl.cwanix.opensun.agentserver.engine.maps;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Service;
import pl.cwanix.opensun.agentserver.engine.maps.structures.MapInfoStructure;
import pl.cwanix.opensun.utils.datatypes.Vector;

import java.util.HashMap;
import java.util.Map;

@Service
public class MapInfoManager implements InitializingBean {

    private Map<Integer, MapInfoStructure> mapInfoStructureMap;

    public MapInfoStructure get(int id) {
        return mapInfoStructureMap.getOrDefault(id, new MapInfoStructure(id, 0, new Vector(0, 0, 0)));
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        mapInfoStructureMap = new HashMap<>();

        mapInfoStructureMap.put(
                10001,
                new MapInfoStructure(
                        10001,
                        0,
                        new Vector(-53.0f,-32.0f,-23.0f)
                )
        );

        mapInfoStructureMap.put(
                10002,
                new MapInfoStructure(
                        10002,
                        0,
                        new Vector(172.07f,141.59f,16.02f)
                )
        );

        mapInfoStructureMap.put(
                10003,
                new MapInfoStructure(
                        10003,
                        0,
                        new Vector(337.22f,336.09f,39.61f)
                )
        );

        mapInfoStructureMap.put(
                10004,
                new MapInfoStructure(
                        10004,
                        0,
                        new Vector(73.61f,-62.10f,3.01f)
                )
        );

        mapInfoStructureMap.put(
                20004,
                new MapInfoStructure(
                        20004,
                        0,
                        new Vector(353.5f,249.8f,34.7f)
                )
        );

        mapInfoStructureMap.put(
                20005,
                new MapInfoStructure(
                        20005,
                        0,
                        new Vector(284.2f,399.8f,48.0f)
                )
        );
    }
}
