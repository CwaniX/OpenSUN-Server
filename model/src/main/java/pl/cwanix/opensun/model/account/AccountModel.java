package pl.cwanix.opensun.model.account;

import lombok.Getter;
import lombok.Setter;
import pl.cwanix.opensun.model.character.CharacterModel;

import java.util.List;

@Getter
@Setter
public class AccountModel {

    private int id;
    private List<CharacterModel> characters;
}
