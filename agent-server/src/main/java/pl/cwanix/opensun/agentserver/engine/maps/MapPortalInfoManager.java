package pl.cwanix.opensun.agentserver.engine.maps;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Service;
import pl.cwanix.opensun.agentserver.engine.maps.structures.PortalInfoStructure;
import pl.cwanix.opensun.utils.bytes.BytesUtils;

import java.util.*;

@Service
@RequiredArgsConstructor
public class MapPortalInfoManager implements InitializingBean {

    private final MapPortalInfoParser mapPortalInfoParser;

    private Map<Integer, PortalInfoStructure> portalInfoStructureMap;
    private Map<Integer, List<Integer>> waypointPortalsMap;

    public PortalInfoStructure get(byte v1, byte from) {
        final int fromAreaId = getFromAreaId(from);
        final int index = generateIndex(v1, from);
        final int portalId = waypointPortalsMap.get(fromAreaId).get(index - 1);

        return portalInfoStructureMap.get(portalId);
    }

    private int getFromAreaId(byte from) {
        return waypointPortalsMap.keySet().toArray(new Integer[0])[from/25];
    }

    private int generateIndex(byte v1, byte from) {
        int key1 = BytesUtils.toUnsigned(v1);

        if (key1 < 50) {
            key1 = 1;
        } else if (key1 < 100){
            key1 = 2;
        } else if (key1 < 200) {
            key1 = 3;
        } else if (key1 > 200) {
            key1 = 4;
        }

        return (from % 25) * 4 + key1;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        portalInfoStructureMap = mapPortalInfoParser.loadPortalInfo();

        waypointPortalsMap = new TreeMap<>();
        portalInfoStructureMap.entrySet()
                .stream()
                .filter(entry -> "WP01".equals(entry.getValue().getAreaTo()))
                .forEach(entry -> {
                    List<Integer> portals = waypointPortalsMap.get(entry.getValue().getMapFrom());

                    if (Objects.isNull(portals)) {
                        portals = new ArrayList<>();
                        portals.add(0);
                        waypointPortalsMap.put(entry.getValue().getMapFrom(), portals);
                    }

                    portals.add(entry.getValue().getId());
                });
    }
}
