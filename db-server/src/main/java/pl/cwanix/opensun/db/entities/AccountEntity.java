package pl.cwanix.opensun.db.entities;

import javax.persistence.Entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class AccountEntity {

	private int id;
	private UserEntity user;
	private CharacterEntity character1;
	private CharacterEntity character2;
	private CharacterEntity character3;
	private CharacterEntity character4;
	private CharacterEntity character5;
}
