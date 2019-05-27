package pl.cwanix.opensun.db.entities;

import java.time.LocalDateTime;

import javax.persistence.Entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class CharacterEntity {

	private int id;
	private UserEntity user;
	private int classCode;
	private String name;
	private int heightCode;
	private int faceCode;
	private int hairCode;
	private int level;
	private int strength;
	private int dexterity;
	private int vitality;
	private int inteligence;
	private int spirit;
	private int skillStat1;
	private int skillStat2;
	private int userPoint;
	private long experience;
	private int hp;
	private int maxHp;
	private int mp;
	private int maxMp;
	private int money;
	private int remainStat;
	private int remailSkill;
	private int selectedStyle;
	private int pkState;
	private int charState;
	private int stateTime;
	private int region;
	private int locationX;
	private int locationY;
	private int locationZ;
	private int titleId;
	private int invisibleOpt;
	private int inventoryLock;
	private byte[] inventoryItem;
	private byte[] tmpInventoryItem;
	private byte[] equipItem;
	private byte[] skill;
	private byte[] quick;
	private byte[] style;
	private byte[] quest;
	private byte[] mission;
	private int playLimitedTime;
	private int pvpPoint;
	private int pvpScore;
	private int pvpGrade;
	private int pvpDraw;
	private int pvpSeries;
	private int pvpKill;
	private int pvpDie;
	private int pvpMaxKill;
	private int pvpMaxDie;
	//private GuildEntity guild;
	private int guildPosition;
	private int guildUserPoint;
	private String guildNickName;
	private LocalDateTime creationDate;
	private LocalDateTime modificationDate;
	private LocalDateTime lastDate;
	private boolean deleted;
}
