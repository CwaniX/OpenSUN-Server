package pl.cwanix.opensun.db.repositories;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;

import pl.cwanix.opensun.db.entities.CharacterEntity;

public interface CharacterEntityRepository extends JpaRepository<CharacterEntity, Long> {

	public CharacterEntity findByName(String name);
	
	@Transactional
	@Procedure(procedureName = "func_create_character")
	public Integer createCharacter(long accountId, String name, int classCode, int heightCode, int faceCode, int hairCode, int slot);
}
