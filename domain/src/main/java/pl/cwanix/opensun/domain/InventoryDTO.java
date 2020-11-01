package pl.cwanix.opensun.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class InventoryDTO {

    private int id;
    private int money;
    private int inventoryLock;
    private byte[] inventoryItem;
    private byte[] tmpInventoryItem;
    private byte[] equipItem;
}
