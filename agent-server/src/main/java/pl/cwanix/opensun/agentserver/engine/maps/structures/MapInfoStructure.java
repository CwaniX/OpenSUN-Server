package pl.cwanix.opensun.agentserver.engine.maps.structures;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import pl.cwanix.opensun.utils.datatypes.Vector;

@Getter
@Setter
@AllArgsConstructor
public class MapInfoStructure {

    private int mapCode;
    private int mapKind;
    private Vector startingVector;
}
