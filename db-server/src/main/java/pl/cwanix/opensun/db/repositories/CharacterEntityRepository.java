package pl.cwanix.opensun.db.repositories;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;

import pl.cwanix.opensun.db.entities.CharacterEntity;

public interface CharacterEntityRepository extends JpaRepository<CharacterEntity, Long> {

	public CharacterEntity findByIdAndDeletedFalse(Long id);
	public List<CharacterEntity> findByAccountIdAndDeletedFalse(long accountId);
	
	@Transactional
	@Procedure(procedureName = "func_create_character")
	public Integer create(long accountId, String name, int classCode, int heightCode, int faceCode, int hairCode, int slot);
	
	@Procedure(procedureName = "func_delete_character")
	public Integer delete(long accountId, int slot);
}
