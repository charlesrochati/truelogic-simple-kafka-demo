package com.truelogic.kafkasample.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "tb_player")
@Setter
@Getter
@RequiredArgsConstructor
@AllArgsConstructor
@Builder
public class Player implements Serializable {

	private static final long serialVersionUID = 1L;
	
    @Id
    @GeneratedValue
    @Column(name = "id")
	private Long id;
	
    @Column(name = "name")
	private String name;
	
	//could've created another table (and be mapped as a enum), but since the types are not predefined, we're just going to save them as a string
    @Column(name = "type_of_player")
	private String type;

}
