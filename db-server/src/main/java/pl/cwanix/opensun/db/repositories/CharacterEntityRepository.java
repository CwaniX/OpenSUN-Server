package pl.cwanix.opensun.db.repositories;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;

import pl.cwanix.opensun.db.entities.CharacterEntity;

public interface CharacterEntityRepository extends JpaRepository<CharacterEntity, Integer> {

	public CharacterEntity findByIdAndDeletedFalse(int id);
	public CharacterEntity findByAccountIdAndSlotAndDeletedFalse(int id, int slot);
	public List<CharacterEntity> findByAccountIdAndDeletedFalse(int accountId);
	
	@Transactional
	@Procedure(procedureName = "func_create_character")
	public Integer create(int accountId, String name, int classCode, int heightCode, int faceCode, int hairCode, int slot);
	
	@Procedure(procedureName = "func_delete_character")
	public Integer delete(int accountId, int slot);
}
