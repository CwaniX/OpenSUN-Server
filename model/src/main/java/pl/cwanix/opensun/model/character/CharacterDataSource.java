package pl.cwanix.opensun.model.character;

import java.util.List;

public interface CharacterDataSource {

    int create(int accountId, String name, int classCode, int heightCode, int faceCode, int hairCode, int slot);
    int delete(int accountId, int slot);
    CharacterModel findCharacter(int accountId, int slot);
    List<CharacterModel> findCharactersList(int accountId);
    int findFreeSlot(int accountId);
    int updateCharacterPosition(int characterId, float x, float y, float z, int angle);
    int updateCharacterRegion(int characterId, float x, float y, float z, int angle, int field);
    int updateCharacterStatistics(int characterId, byte attributeCode);
}
