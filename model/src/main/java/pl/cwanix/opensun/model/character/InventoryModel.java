package pl.cwanix.opensun.model.character;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class InventoryModel {

    private int id;
    private int money;
    private int inventoryLock;
    private byte[] inventoryItem;
    private byte[] tmpInventoryItem;
    private byte[] equipItem;
}
