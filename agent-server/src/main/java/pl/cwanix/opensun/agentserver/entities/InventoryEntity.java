package pl.cwanix.opensun.agentserver.entities;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class InventoryEntity {

    private int id;
    private int money;
    private int inventoryLock;
    private byte[] inventoryItem;
    private byte[] tmpInventoryItem;
    private byte[] equipItem;
}
