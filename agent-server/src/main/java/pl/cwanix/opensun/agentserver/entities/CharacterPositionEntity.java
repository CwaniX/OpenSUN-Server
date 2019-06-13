package pl.cwanix.opensun.agentserver.entities;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CharacterPositionEntity {

	private int id;
	private int region;
	private int locationX;
	private int locationY;
	private int locationZ;
}
