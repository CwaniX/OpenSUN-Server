package pl.cwanix.opensun.model.character;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CharacterPositionModel {

    private int id;
    private int region;
    private int angle;
    private float locationX;
    private float locationY;
    private float locationZ;
}
