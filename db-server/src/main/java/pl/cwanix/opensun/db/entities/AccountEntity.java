package pl.cwanix.opensun.db.entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "account")
public class AccountEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_account_generator")
	@SequenceGenerator(name = "seq_account_generator", sequenceName = "seq_account")
	private Long id;
	@OneToMany(mappedBy = "account")
	private List<CharacterEntity> characters;
}
