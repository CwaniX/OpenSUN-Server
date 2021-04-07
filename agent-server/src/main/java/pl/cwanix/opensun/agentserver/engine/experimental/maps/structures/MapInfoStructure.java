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
    private int dCode;
    private int mKind;
    private int mType;
    private int qCode;
    private int minUserNum;
    private int maxUserNum;
    private int minLv;
    private int maxLv;
    private String mapControlId;
    private int text1;
    private int text2;
    private int text3;
    private int startAreaId;
    private byte mapClass;
    private int[] fCode;
    private String[] gCode;
    private int[]environmentCode;
    private int[] imageCode;
}
