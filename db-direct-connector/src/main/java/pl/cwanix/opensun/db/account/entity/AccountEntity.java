package pl.cwanix.opensun.db.account.entity;

import lombok.Getter;
import lombok.Setter;
import pl.cwanix.opensun.db.character.entity.CharacterEntity;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "account", schema = "public")
public class AccountEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_account_generator")
    @SequenceGenerator(name = "seq_account_generator", sequenceName = "seq_account")
    private int id;
    @OneToMany(mappedBy = "account", fetch = FetchType.EAGER)
    private List<CharacterEntity> characters;
}
