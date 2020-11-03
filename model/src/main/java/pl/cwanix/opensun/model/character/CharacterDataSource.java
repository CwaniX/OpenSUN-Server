package pl.cwanix.opensun.model.character;

import java.util.List;

public interface CharacterDataSource {

    int createCharacter(
            final int accountId,
            final String charName,
            final int classCode,
            final int heightCode,
            final int faceCode,
            final int hairCode,
            final int slot
    );
    void deleteCharacter(final int userId, final int slot);
    CharacterModel findCharacter(final int accountId, final int slot);
    List<CharacterModel> findCharactersList(final int accountId);
    int findFreeSlot(final int userId);
    int updateCharacterPosition(
            final int characterId,
            final float x,
            final float y,
            final float z,
            final int angle
    );
    int updateCharacterStatistics(final int characterId, final byte attributeCode);
}
