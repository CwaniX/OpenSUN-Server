package pl.cwanix.opensun.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CharacterPositionDTO {

    private int id;
    private int region;
    private int angle;
    private float locationX;
    private float locationY;
    private float locationZ;
}
