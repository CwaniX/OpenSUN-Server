package pl.cwanix.opensun.db.character.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Getter
@Setter
@Entity
@Table(name = "inventory", schema = "public")
public class InventoryEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_inventory_generator")
    @SequenceGenerator(name = "seq_inventory_generator", sequenceName = "seq_inventory")
    private int id;
    private int money;
    private int inventoryLock;
    private byte[] inventoryItem;
    private byte[] tmpInventoryItem;
    private byte[] equipItem;
}
