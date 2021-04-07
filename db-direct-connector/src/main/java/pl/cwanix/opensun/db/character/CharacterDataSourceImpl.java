package pl.cwanix.opensun.db.character;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import pl.cwanix.opensun.db.character.entity.CharacterEntity;
import pl.cwanix.opensun.db.character.repository.CharacterEntityRepository;
import pl.cwanix.opensun.model.character.CharacterDataSource;
import pl.cwanix.opensun.model.character.CharacterModel;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CharacterDataSourceImpl implements CharacterDataSource {

    private final CharacterEntityRepository characterEntityRepository;
    private final ModelMapper modelMapper;

    @Override
    public int create(final int accountId, final String name, final int classCode, final int heightCode, final int faceCode, final int hairCode, final int slot) {
        return characterEntityRepository.create(accountId, name, classCode, heightCode, faceCode, hairCode, slot);
    }

    @Override
    public int delete(final int accountId, final int slot) {
        return characterEntityRepository.delete(accountId, slot);
    }

    @Override
    public CharacterModel findCharacter(final int accountId, final int slot) {
        final CharacterEntity entity = characterEntityRepository.findByAccountIdAndSlotAndDeletedFalse(accountId, slot);

        return modelMapper.map(entity, CharacterModel.class);
    }

    @Override
    public List<CharacterModel> findCharactersList(final int accountId) {
        final List<CharacterEntity> entities = characterEntityRepository.findByAccountIdAndDeletedFalse(accountId);

        return entities.stream()
                .map(entity -> modelMapper.map(entity, CharacterModel.class))
                .collect(Collectors.toList());
    }

    @Override
    public int findFreeSlot(final int accountId) {
        return characterEntityRepository.findFreeSlot(accountId);
    }

    @Override
    public int updateCharacterPosition(final int characterId, final float x, final float y, final float z, final int angle) {
        return characterEntityRepository.updatePosition(characterId, x, y, z, angle);
    }

    @Override
    public int updateCharacterStatistics(final int characterId, final byte attributeCode) {
        return characterEntityRepository.updateStatistics(characterId, attributeCode);
    }
}
