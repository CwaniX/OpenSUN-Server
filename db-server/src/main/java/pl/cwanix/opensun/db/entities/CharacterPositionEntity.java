package pl.cwanix.opensun.db.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class CharacterPositionEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_inventory_generator")
	@SequenceGenerator(name = "seq_inventory_generator", sequenceName = "seq_inventory")
	private Long id;
	private int region;
	private int locationX;
	private int locationY;
	private int locationZ;
}
