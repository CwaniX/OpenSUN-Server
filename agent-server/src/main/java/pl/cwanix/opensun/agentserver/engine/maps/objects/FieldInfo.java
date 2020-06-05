package pl.cwanix.opensun.agentserver.engine.maps.objects;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Marker;
import org.slf4j.MarkerFactory;
import pl.cwanix.opensun.agentserver.engine.maps.structures.FieldInfoStructure;
import pl.cwanix.opensun.utils.datatypes.Vector;
import pl.cwanix.opensun.utils.files.SUNArchive;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Getter
@Setter
@Slf4j
public class FieldInfo {

	private static final Marker MARKER = MarkerFactory.getMarker("FIELD INFO");

	private final FieldInfoStructure fieldInfoStructure;

	private boolean viewport;
	private Vector startingVector;
	private int sectorSize;
	private int sectorXNum;
	private int sectorYNum;
	private int totalSectorNum;
	private int shiftMinX;
	private int shiftMinY;
	private int shiftMaxX;
	private int shiftMaxY;
	private WorldBase worldBase;
	private SectorInfo sectorInfo;
	private TriggerGroupInfo triggerGroupInfo;
	private Map<Integer, MapObjectInfo> mapObjectInfoMap;
	private List<Integer> startTilesList;

	public FieldInfo(FieldInfoStructure fieldInfoStructure) {
		this.fieldInfoStructure = fieldInfoStructure;
		this.mapObjectInfoMap = new HashMap<>();
		this.startTilesList = new ArrayList<>();
		this.triggerGroupInfo = new TriggerGroupInfo();

		//worldBase.create()?
	}

	public void load() {
		SUNArchive archive = new SUNArchive();

		if (archive.loadFile(fieldInfoStructure.getPath())) {
			log.error(MARKER, "Unable to load field file: {}", fieldInfoStructure.getPath());
		}
	}

	private void loadMapObjectInfo(SUNArchive archive) {

	}
}
