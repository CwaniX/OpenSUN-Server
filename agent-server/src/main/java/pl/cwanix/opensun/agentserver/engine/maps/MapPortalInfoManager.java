package pl.cwanix.opensun.agentserver.engine.maps;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Service;
import pl.cwanix.opensun.agentserver.engine.maps.structures.PortalInfoStructure;
import pl.cwanix.opensun.utils.bytes.BytesUtils;

import java.util.Map;

@SuppressWarnings("checkstyle:MagicNumber")
@Service
@RequiredArgsConstructor
public class MapPortalInfoManager implements InitializingBean {

    private final MapPortalInfoParser mapPortalInfoParser;

    private Map<Integer, PortalInfoStructure> portalInfoStructureMap;

    public PortalInfoStructure get(final byte v1, final byte from) {
        final int index = generateIndex(v1, from);

        return portalInfoStructureMap.get(index);
    }

    private int generateIndex(final byte v1, final byte from) {
        int key1 = BytesUtils.toUnsigned(v1);

        return (key1 / 64) + (from * 4);
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        portalInfoStructureMap = mapPortalInfoParser.loadPortalInfo();
    }
}
