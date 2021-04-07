package pl.cwanix.opensun.db.account.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "user", schema = "public")
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_user_generator")
    @SequenceGenerator(name = "seq_user_generator", sequenceName = "seq_user")
    private int id;
    @OneToOne(fetch = FetchType.EAGER)
    private AccountEntity account;
    private String name;
    private String password;
    private LocalDateTime creationDate;
    private LocalDateTime modificationDate;
    private LocalDateTime lastLoginDate;
}
