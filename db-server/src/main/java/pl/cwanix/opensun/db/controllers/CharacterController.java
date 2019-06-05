package pl.cwanix.opensun.db.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import pl.cwanix.opensun.db.repositories.CharacterEntityRepository;

@RestController
@RequestMapping("/character")
@RequiredArgsConstructor
public class CharacterController {

	private final CharacterEntityRepository characterEntityRepository;
	
	@GetMapping(path = "/", produces = "application/json")
	public Integer createCharacter() {
		return characterEntityRepository.createCharacter(1L, "Mirka", 1, 0, 0, 0, 0);
	}
}
