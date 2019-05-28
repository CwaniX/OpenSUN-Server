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
public class AccountEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_account_generator")
	@SequenceGenerator(name = "seq_account_generator", sequenceName = "seq_account")
	private Long id;
	//private UserEntity user;
	//private CharacterEntity character1;
	//private CharacterEntity character2;
	//private CharacterEntity character3;
	//private CharacterEntity character4;
	//private CharacterEntity character5;
}
