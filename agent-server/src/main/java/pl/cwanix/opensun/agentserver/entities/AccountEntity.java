package pl.cwanix.opensun.agentserver.entities;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AccountEntity {

	private Long id;
	private List<CharacterEntity> characters;
}
