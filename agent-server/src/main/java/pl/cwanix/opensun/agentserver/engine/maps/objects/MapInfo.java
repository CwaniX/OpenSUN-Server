package pl.cwanix.opensun.agentserver.engine.maps.objects;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import pl.cwanix.opensun.agentserver.engine.maps.structures.MapInfoStructure;

import java.util.Map;

@Getter
@Setter
@RequiredArgsConstructor
public class MapInfo {

    private final MapInfoStructure mapInfoStructure;
    private Map<Integer, FieldInfo> fieldInfoMap;
}
