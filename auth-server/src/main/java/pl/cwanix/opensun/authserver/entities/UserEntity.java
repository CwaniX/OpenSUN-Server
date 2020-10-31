package pl.cwanix.opensun.authserver.entities;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode(of = { "id", "name" })
public class UserEntity {

    private int id;
    private String name;
    private String password;
}
