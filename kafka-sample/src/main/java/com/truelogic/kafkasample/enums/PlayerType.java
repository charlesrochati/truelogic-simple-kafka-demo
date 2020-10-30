package com.truelogic.kafkasample.enums;

public enum PlayerType {
	
	EXPERT("expert"),
	NOVICE("novice");
	
	
	private String type;
	
	PlayerType(String type) {
		
		this.type = type;
	}
	
	public String getType() {
		return this.type;
	}
}
