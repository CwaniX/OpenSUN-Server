package pl.cwanix.opensun.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@EqualsAndHashCode(of = { "id", "name" })
public class UserDTO {

    private int id;
    private AccountDTO account;
    private String name;
    private String password;
    private LocalDateTime creationDate;
    private LocalDateTime modificationDate;
    private LocalDateTime lastLoginDate;
}
