package com.truelogic.kafkasample.service;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.truelogic.kafkasample.domain.Player;
import com.truelogic.kafkasample.repository.PlayerRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PlayerService {
	
	private final PlayerRepository playerRepository;


	@Transactional 
	public void save(Player player) {
		// run validations
		playerRepository.save(player);
	}
}
