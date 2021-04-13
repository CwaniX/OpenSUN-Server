package pl.cwanix.opensun.agentserver.engine.maps.structures;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PortalInfoStructure {

    private int id;
    private byte mapType;
    private byte moveType;
    private int mapFrom;
    private int fieldFrom;
    private String areaFrom;
    private int mapTo;
    private int fieldTo;
    private String areaTo;
    private int minLvl;
    private int maxLvl;
    private int missionCode;
    private int questCode;
    private int itemCode;
    private byte itemNum;
    private int wasteItem;
    private int heim;
}
