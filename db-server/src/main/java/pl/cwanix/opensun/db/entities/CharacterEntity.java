package pl.cwanix.opensun.db.entities;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "character", schema = "public")
public class CharacterEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_character_generator")
    @SequenceGenerator(name = "seq_character_generator", sequenceName = "seq_character")
    private int id;
    @JsonManagedReference
    @ManyToOne
    private AccountEntity account;
    private int classCode;
    private int heightCode;
    private int faceCode;
    private int hairCode;
    private int level;
    private int strength;
    private int dexterity;
    private int vitality;
    private int intelligence;
    private int spirit;
    private int skillStat1;
    private int skillStat2;
    private int userPoint;
    private long experience;
    private int hp;
    private int maxHp;
    private int mp;
    private int maxMp;
    private int remainStat;
    private int remainSkill;
    private int selectedStyle;
    private int pkState;
    private int charState;
    private int slot;
    private int stateTime;
    @OneToOne
    private CharacterPositionEntity position;
    private int titleId;
    private int invisibleOpt;
    @OneToOne
    private InventoryEntity inventory;
    private byte[] skill;
    private byte[] quick;
    private byte[] style;
    private byte[] quest;
    private byte[] mission;
    private int playLimitedTime;
    // private int pvpPoint;
    // private int pvpScore;
    // private int pvpGrade;
    // private int pvpDraw;
    // private int pvpSeries;
    // private int pvpKill;
    // private int pvpDie;
    // private int pvpMaxKill;
    // private int pvpMaxDie;
    // private GuildEntity guild;
    // private int guildPosition;
    // private int guildUserPoint;
    private String name;
    // private String guildNickName;
    private LocalDateTime creationDate;
    private LocalDateTime modificationDate;
    private LocalDateTime lastLoginDate;
    private boolean deleted;
}
