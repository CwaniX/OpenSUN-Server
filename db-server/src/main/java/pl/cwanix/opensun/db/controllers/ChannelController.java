package pl.cwanix.opensun.db.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.cwanix.opensun.db.entities.ChannelEntity;
import pl.cwanix.opensun.db.repositories.ChannelEntityRepository;

import java.util.List;

@RestController
@RequestMapping("/channel")
@RequiredArgsConstructor
public class ChannelController {

	private final ChannelEntityRepository channelRepository;

	@GetMapping(path = "/findAll", produces = "application/json")
	public List<ChannelEntity> findAll() {
		return channelRepository.findAll();
	}
}
