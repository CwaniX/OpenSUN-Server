package pl.cwanix.opensun.agentserver.entities;

import java.time.LocalDateTime;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CharacterEntity {

	private int id;
	private AccountEntity account;
	private int classCode;
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
	private int remainStat;
	private int remainSkill;
	private int selectedStyle;
	private int pkState;
	private int charState;
	private int stateTime;
	private int slot;
	private CharacterPositionEntity position;
	private int titleId;
	private int invisibleOpt;
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
