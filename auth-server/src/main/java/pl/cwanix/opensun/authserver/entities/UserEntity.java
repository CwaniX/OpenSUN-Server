package pl.cwanix.opensun.authserver.entities;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserEntity {

	private Long id;
	private String name;
	private String password;
}
