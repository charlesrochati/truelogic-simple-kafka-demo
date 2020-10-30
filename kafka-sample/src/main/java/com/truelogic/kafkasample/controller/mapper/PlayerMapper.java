package com.truelogic.kafkasample.controller.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import com.truelogic.kafkasample.domain.Player;
import com.truelogic.kafkasample.dto.PlayerDTO;

@Mapper(componentModel = "spring")
public interface PlayerMapper {
	
	PlayerDTO toDTO(Player player);
	Player toEntity(PlayerDTO playerDTO);
	
	List<PlayerDTO> toDTOList(List<Player> players);
	List<Player> toEntityList(List<PlayerDTO> playersDTO);

}
