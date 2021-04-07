package pl.cwanix.opensun.db.character.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Getter
@Setter
@Entity
@Table(name = "character_position", schema = "public")
public class CharacterPositionEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_character_position_generator")
    @SequenceGenerator(name = "seq_character_position_generator", sequenceName = "seq_character_position")
    private int id;
    private int region;
    private int angle;
    private float locationX;
    private float locationY;
    private float locationZ;
}
