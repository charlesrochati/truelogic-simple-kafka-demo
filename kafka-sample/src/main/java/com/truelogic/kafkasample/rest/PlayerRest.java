package com.truelogic.kafkasample.rest;

import java.util.List;
import java.util.Map;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.truelogic.kafkasample.dto.PlayerAddedDTO;
import com.truelogic.kafkasample.dto.PlayerDTO;

@RequestMapping(value = PlayerRest.PATH, produces = MediaType.APPLICATION_JSON_VALUE)
public interface PlayerRest {
	
	String PATH = "/players";
	
    @PostMapping
    PlayerAddedDTO save(@RequestBody Map<String, List<PlayerDTO>> players);
}
