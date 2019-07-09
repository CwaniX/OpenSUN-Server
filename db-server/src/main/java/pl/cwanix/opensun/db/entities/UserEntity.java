package pl.cwanix.opensun.db.entities;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "user", schema="public")
public class UserEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_user_generator")
	@SequenceGenerator(name = "seq_user_generator", sequenceName = "seq_user")
	private int id;
	@OneToOne
	private AccountEntity account;
	private String name;
	private String password;
	private LocalDateTime creationDate;
	private LocalDateTime modificationDate;
	private LocalDateTime lastLoginDate;
}
