package pl.cwanix.opensun.agentserver.entities;

import java.time.LocalDateTime;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode(of = { "id", "name" })
public class UserEntity {

	private Long id;
	private AccountEntity account;
	private String name;
	private String password;
	private LocalDateTime creationDate;
	private LocalDateTime modificationDate;
	private LocalDateTime lastLoginDate;
}
