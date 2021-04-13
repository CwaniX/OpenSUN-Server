package pl.cwanix.opensun.agentserver.engine.experimental.maps.objects;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import pl.cwanix.opensun.agentserver.engine.experimental.maps.structures.MapInfoStructure;

@Getter
@Setter
@RequiredArgsConstructor
public class MapInfo {

    private final MapInfoStructure mapInfoStructure;
    private final FieldInfo fieldInfo;
}
