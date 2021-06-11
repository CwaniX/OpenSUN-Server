package pl.cwanix.opensun.agentserver.engine.npc.structures;

import lombok.Getter;
import lombok.Setter;

import java.util.Map;

@Getter
@Setter
public class ShopTabStructure {

    private int id;
    private int shopId;
    private Map<Integer, ShopItemStructure> items;
}
