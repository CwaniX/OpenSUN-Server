package pl.cwanix.opensun.agentserver.engine.maps.objects;

import lombok.Getter;
import lombok.Setter;
import pl.cwanix.opensun.utils.datatypes.SUNId;
import pl.cwanix.opensun.utils.datatypes.Vector;

@Getter
@Setter
public class MapObjectInfo {

	private int mapObjectInfoId;
	private SUNId id;
	private int attribute;
	private Vector pos;
	private Vector rot;
	private Vector scale;
	//private BoundingVolume boundingVolume;

}
