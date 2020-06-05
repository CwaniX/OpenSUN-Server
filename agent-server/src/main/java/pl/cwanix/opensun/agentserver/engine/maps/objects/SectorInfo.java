package pl.cwanix.opensun.agentserver.engine.maps.objects;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class SectorInfo {

	private static final int MAX_NEIGHBOR_SECTOR_NUM = 8;

	private int sectorIndex;
	private List<SectorInfo> neighborSectorInfoList;
}
