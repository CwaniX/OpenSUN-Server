package pl.cwanix.opensun.agentserver.packets.structures;

import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.ArrayUtils;
import pl.cwanix.opensun.commonserver.packets.PacketStructure;
import pl.cwanix.opensun.utils.datatypes.FixedLengthField;

@RequiredArgsConstructor
public class PlayerInfoPacketStructure implements PacketStructure { //PLAYER_INFO_FOR_PACKET

    private final FixedLengthField exp; //4
    private final FixedLengthField remainStat; //4
    private final FixedLengthField remainSkill; //4
    private final FixedLengthField money; //8
    private final FixedLengthField selectStyleCode; //2
    private final FixedLengthField maxHp; //2
    private final FixedLengthField hp; //2
    private final FixedLengthField maxMp; //2
    private final FixedLengthField mp; //2
    private final FixedLengthField moveSpeedRatio; //2
    private final FixedLengthField attSpeedRatio; //2
    private final FixedLengthField stateTime; //8
    private final FixedLengthField titleId; //16
    private final FixedLengthField titleTime; //8
    private final FixedLengthField inventoryLock; //1
    private final FixedLengthField strength; //2
    private final FixedLengthField dexterity; //2
    private final FixedLengthField vitality; //2
    private final FixedLengthField intelligence; //2
    private final FixedLengthField spirit; //2
    private final FixedLengthField skillStat1; //2
    private final FixedLengthField skillStat2; //2
    private final FixedLengthField additionalOptions; //16

    /*struct {
        WORD		m_byGMGrade		: 3;
        WORD		m_byPCBangUser	: 1;
        WORD		m_byCondition	: 1;
        WORD		m_byPKState		: 3;
        WORD		m_byCharState	: 8;
    };*/

    private final FixedLengthField playLimitedTime; //4
    private final FixedLengthField invisibleOptFlag; //1

    @Override
    public Object[] getOrderedFields() {
        return ArrayUtils.toArray(
                exp,
                remainStat,
                remainSkill,
                money,
                selectStyleCode,
                maxHp,
                hp,
                maxMp,
                mp,
                moveSpeedRatio,
                attSpeedRatio,
                stateTime,
                titleId,
                titleTime,
                inventoryLock,
                strength,
                dexterity,
                vitality,
                intelligence,
                spirit,
                skillStat1,
                skillStat2,
                additionalOptions,
                playLimitedTime,
                invisibleOptFlag
        );
    }
}
