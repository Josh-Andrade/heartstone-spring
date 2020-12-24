package com.hearstone.cartas.domain.model;

public enum Tipo {
	
	MAGIA, CRIATURA;
	
	public static Tipo valueOfByName(String name) {
		return valueOf(name.toUpperCase());
	}
}
