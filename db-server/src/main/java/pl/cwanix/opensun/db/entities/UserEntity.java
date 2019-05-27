package pl.cwanix.opensun.db.entities;

import javax.persistence.Entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class UserEntity {

	private int id;
	private String login;
	private String password;
}
