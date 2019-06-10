package pl.cwanix.opensun.agentserver.entities;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CharacterEntityList {

	private List<CharacterEntity> list;
	
	public CharacterEntityList() {
		list = new ArrayList<>();
	}
}
