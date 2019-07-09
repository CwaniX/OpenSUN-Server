package pl.cwanix.opensun.db.entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "account", schema="public")
public class AccountEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_account_generator")
	@SequenceGenerator(name = "seq_account_generator", sequenceName = "seq_account")
	private int id;
	@JsonBackReference
	@OneToMany(mappedBy = "account")
	private List<CharacterEntity> characters;
}
