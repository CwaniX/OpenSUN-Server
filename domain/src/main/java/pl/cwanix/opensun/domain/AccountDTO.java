package pl.cwanix.opensun.domain;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class AccountDTO {

    private int id;
    private List<CharacterDTO> characters;
}
