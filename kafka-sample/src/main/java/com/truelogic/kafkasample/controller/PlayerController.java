package com.truelogic.kafkasample.controller;

import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.RestController;

import com.truelogic.kafkasample.controller.mapper.PlayerMapper;
import com.truelogic.kafkasample.domain.Player;
import com.truelogic.kafkasample.dto.PlayerAddedDTO;
import com.truelogic.kafkasample.dto.PlayerDTO;
import com.truelogic.kafkasample.enums.PlayerType;
import com.truelogic.kafkasample.rest.PlayerRest;
import com.truelogic.kafkasample.service.PlayerService;
import com.truelogic.kafkasample.service.kafka.NovicePlayerProducer;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class PlayerController implements PlayerRest {

	private final PlayerMapper playerMapper;
	private final PlayerService playerService;
	private final NovicePlayerProducer novicePlayerProducer;

	@Override
	public PlayerAddedDTO save(Map<String, List<PlayerDTO>> map) {
		List<Player> players = playerMapper.toEntityList(map.get(map.keySet().toArray()[0]));

		PlayerAddedDTO result = new PlayerAddedDTO();

		players.stream().filter(player -> player.getType().equals(PlayerType.EXPERT.getType())).findFirst().ifPresent(player -> {
			playerService.save(player);
			result.getResult().add("player Sub zero stored in DB");			
		});
		
		players.stream().filter(player -> player.getType().equals(PlayerType.NOVICE.getType())).findFirst().ifPresent(player -> {
			novicePlayerProducer.send(player);
			result.getResult().add("player Scorpion sent to Kafka topic");
		});
		
		if (players.stream().anyMatch(player -> !player.getType().equals(PlayerType.EXPERT.getType()) && !player.getType().equals(PlayerType.NOVICE.getType()))) {
			result.getResult().add("player Reptile did not fit");
		}

		return result;
	}

}
