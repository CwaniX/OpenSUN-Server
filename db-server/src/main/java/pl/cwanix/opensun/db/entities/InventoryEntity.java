package pl.cwanix.opensun.db.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "inventory")
public class InventoryEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_inventory_generator")
	@SequenceGenerator(name = "seq_inventory_generator", sequenceName = "seq_inventory")
	private Long id;
	private int money;
	private int inventoryLock;
	private byte[] inventoryItem;
	private byte[] tmpInventoryItem;
	private byte[] equipItem;
}
