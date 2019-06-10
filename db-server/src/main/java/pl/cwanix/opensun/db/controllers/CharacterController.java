package pl.cwanix.opensun.db.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import pl.cwanix.opensun.db.entities.CharacterEntity;
import pl.cwanix.opensun.db.repositories.CharacterEntityRepository;

@RestController
@RequestMapping("/character")
@RequiredArgsConstructor
public class CharacterController {

	private final CharacterEntityRepository characterEntityRepository;

	@PostMapping(path = "/create", produces = "application/json")
	public Integer create(
			@RequestParam("accountId") int accountId,
			@RequestParam("name") String name,
			@RequestParam("classCode") int classCode,
			@RequestParam("heightCode") int heightCode,
			@RequestParam("faceCode") int faceCode,
			@RequestParam("hairCode") int hairCode,
			@RequestParam("slot") int slot) {
		return characterEntityRepository.create(accountId, name, classCode, heightCode, faceCode, hairCode, slot);
	}
	
	@DeleteMapping(path = "/delete", produces = "application/json")
	public Integer delete(@RequestParam("accountId") int accountId, @RequestParam("slot") int slot) {
		return characterEntityRepository.delete(accountId, slot);
	}
	
	@GetMapping(path = "/findByAccount", produces = "application/json")
	public List<CharacterEntity> findAll(@RequestParam("accountId") int accountId) {
		return characterEntityRepository.findByAccountIdAndDeletedFalse(accountId);
	}
	
	@GetMapping(path = "/findById", produces = "application/json")
	public CharacterEntity findById(@RequestParam("id") int id) {
		return characterEntityRepository.findByIdAndDeletedFalse(id);
	}
}
