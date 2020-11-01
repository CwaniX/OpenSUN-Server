package pl.cwanix.opensun.agentserver.packets.structures;

import org.apache.commons.lang3.ArrayUtils;

import pl.cwanix.opensun.domain.CharacterDTO;
import pl.cwanix.opensun.commonserver.packets.PacketStructure;
import pl.cwanix.opensun.utils.datatypes.FixedLengthField;

@SuppressWarnings("checkstyle:MagicNumber")
public class ClientCharacterPartPacketStructure implements PacketStructure {

    private final FixedLengthField slot;
    private final FixedLengthField size;
    private final FixedLengthField charName;
    private final FixedLengthField heightCode;
    private final FixedLengthField faceCode;
    private final FixedLengthField hairCode;
    private final FixedLengthField classCode;
    private final FixedLengthField level;
    private final FixedLengthField region;
    private final FixedLengthField x;
    private final FixedLengthField y;
    private final FixedLengthField z;
    private final FixedLengthField equipNumber;
    private final EquipItemInfoPacketStructure equipItemInfo;
    private final FixedLengthField unknown1;
    private final FixedLengthField unknown2;
    private final FixedLengthField unknown3;
    private final FixedLengthField unknown4;

    public ClientCharacterPartPacketStructure(final CharacterDTO character) {
        slot = new FixedLengthField(1, character.getSlot());
        size = new FixedLengthField(1, 0x10);
        charName = new FixedLengthField(16, character.getName());
        heightCode = new FixedLengthField(1, character.getHeightCode());
        faceCode = new FixedLengthField(1, character.getFaceCode());
        hairCode = new FixedLengthField(1, character.getHairCode());
        classCode = new FixedLengthField(1, character.getClassCode());
        level = new FixedLengthField(2, character.getLevel());
        region = new FixedLengthField(4, character.getPosition().getRegion());
        x = new FixedLengthField(2, character.getPosition().getLocationX());
        y = new FixedLengthField(2, character.getPosition().getLocationY());
        z = new FixedLengthField(2, character.getPosition().getLocationZ());
        equipNumber = new FixedLengthField(1, 0);
        equipItemInfo = new EquipItemInfoPacketStructure(character.getInventory().getEquipItem());
        unknown1 = new FixedLengthField(1);
        unknown2 = new FixedLengthField(32);
        unknown3 = new FixedLengthField(3);
        unknown4 = new FixedLengthField(4);
    }

    @Override
    public Object[] getOrderedFields() {
        return ArrayUtils.toArray(slot, size, charName, heightCode, faceCode, hairCode, classCode, level, region, x, y,
                z, equipNumber, equipItemInfo, unknown1, unknown2, unknown3, unknown4);
    }
}
