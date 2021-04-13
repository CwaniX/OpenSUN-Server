package pl.cwanix.opensun.agentserver.engine.experimental.maps.structures;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MapInfoStructure {

    public static final int MAX_FIELD_NUMBER = 6;

    private int mapCode;
    private int mapKind;
    private String mName;
    private int nCode;
    private int fnCode;
    private int dCode;
    private int anCode;
    private int guildEnt;
    private int guildItem;
    private int timeLim;
    private int mKind;
    private int mType;
    private int minUser;
    private int maxUser;
    private int minLv;
    private int maxLv;
    private int freePassLv;
    private String startId;
    private String startId2;
    private int entCount;
    private int class1;
    private int fCount;
    private int completeQCode;
    private int completeMCode;
    private int continentCode;
    private byte[] mMap;
    private int[] pMap;
    private int[] cMap;
}
