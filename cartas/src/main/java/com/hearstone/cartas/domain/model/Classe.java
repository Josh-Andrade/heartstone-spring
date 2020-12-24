package com.hearstone.cartas.domain.model;

public enum Classe {
	
	MAGO,
	PALADINO,
	CACADOR,
	DRUIDA,
	QUALQUER;
	
	public static Classe valueOfByName(String name) {
		return valueOf(name.toUpperCase());
	}
}
