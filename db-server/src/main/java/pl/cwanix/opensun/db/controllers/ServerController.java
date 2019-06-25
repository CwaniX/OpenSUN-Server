package pl.cwanix.opensun.db.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import pl.cwanix.opensun.db.entities.ServerEntity;
import pl.cwanix.opensun.db.repositories.ServerEntityRepository;

@RestController
@RequestMapping("/server")
@RequiredArgsConstructor
public class ServerController {
	
	private final ServerEntityRepository serverRepository;

	@GetMapping(path = "/findAll", produces = "application/json")
	public List<ServerEntity> findAll() {
		return serverRepository.findAll();
	}
}
