package pl.cwanix.opensun.db.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import pl.cwanix.opensun.db.entities.UserEntity;
import pl.cwanix.opensun.db.repositories.UserEntityRepository;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {
	
	private final UserEntityRepository userEntityRepository;
	
	@GetMapping(path = "/create", produces = "application/json")
	public Integer create(@RequestParam("name") String name, @RequestParam("password") String password) {
		return userEntityRepository.create("test", "test");
	}
	
	@GetMapping(path = "/findAll", produces = "application/json")
	public List<UserEntity> findAll() {
		return userEntityRepository.findAll();
	}

	@GetMapping(path = "/findById", produces = "application/json")
	public UserEntity findById(@RequestParam("id") Long id) {
		return userEntityRepository.findById(id).orElse(null);
	}
	
	@GetMapping(path = "/findByName", produces = "application/json")
	public UserEntity findByName(@RequestParam("name") String name) {
		return userEntityRepository.findByName(name);
	}
}
