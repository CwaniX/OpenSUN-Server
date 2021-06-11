package pl.cwanix.opensun.agentserver.engine.npc.structures;

import lombok.Getter;
import lombok.Setter;

import java.util.Map;

@Getter
@Setter
public class ShopInfoStructure {

    private int id;
    private String name;
    private int lottoRatio;
    private Map<Integer, ShopTabStructure> tabs;
}
