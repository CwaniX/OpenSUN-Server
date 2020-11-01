package pl.cwanix.opensun.db.repositories;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;

import pl.cwanix.opensun.db.entities.CharacterEntity;

public interface CharacterEntityRepository extends JpaRepository<CharacterEntity, Integer> {

    CharacterEntity findByIdAndDeletedFalse(int id);
    CharacterEntity findByAccountIdAndSlotAndDeletedFalse(int id, int slot);
    List<CharacterEntity> findByAccountIdAndDeletedFalse(int accountId);

    @Transactional
    @Procedure(procedureName = "func_create_character")
    Integer create(int accountId, String name, int classCode, int heightCode, int faceCode, int hairCode, int slot);

    @Procedure(procedureName = "func_delete_character")
    Integer delete(int accountId, int slot);

    @Procedure(procedureName = "func_find_free_slot")
    Integer findFreeSlot(int accountId);

    @Procedure(procedureName = "func_update_character_position")
    Integer updatePosition(int id, float x, float y, float z, int angle);

    @Procedure(procedureName = "func_update_character_statistics")
    Integer updateStatistics(int id, byte attributeCode);
}
