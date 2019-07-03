package pl.cwanix.opensun.agentserver.entities;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CharacterPositionEntity {

	private int id;
	private int region;
	private float locationX;
	private float locationY;
	private float locationZ;
}
