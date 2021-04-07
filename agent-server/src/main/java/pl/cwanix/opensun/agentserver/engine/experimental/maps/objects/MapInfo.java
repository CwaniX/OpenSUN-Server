package pl.cwanix.opensun.agentserver.engine.experimental.maps.objects;

import lombok.Getter;
import lombok.Setter;
import pl.cwanix.opensun.agentserver.engine.experimental.maps.structures.MapInfoStructure;

import java.util.HashMap;
import java.util.Map;

@Getter
@Setter
public class MapInfo {

    private final MapInfoStructure mapInfoStructure;
    private final Map<Integer, FieldInfo> fieldInfoMap;

    public MapInfo(final MapInfoStructure mapInfoStructure) {
        this.mapInfoStructure = mapInfoStructure;
        this.fieldInfoMap = new HashMap<>();
    }
}
