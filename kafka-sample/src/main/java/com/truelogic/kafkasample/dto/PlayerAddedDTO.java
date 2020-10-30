package com.truelogic.kafkasample.dto;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class PlayerAddedDTO {
	private List<String> result = new ArrayList<>();
}