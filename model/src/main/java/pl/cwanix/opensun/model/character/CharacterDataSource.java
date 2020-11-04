package pl.cwanix.opensun.model.character;

import java.util.List;

public interface CharacterDataSource {

    int createCharacter(int accountId, String charName, int classCode, int heightCode, int faceCode, int hairCode, int slot);
    void deleteCharacter(int userId, int slot);
    CharacterModel findCharacter(int accountId, int slot);
    List<CharacterModel> findCharactersList(int accountId);
    int findFreeSlot(int userId);
    int updateCharacterPosition(int characterId, float x, float y, float z, int angle);
    int updateCharacterStatistics(int characterId, byte attributeCode);
}
