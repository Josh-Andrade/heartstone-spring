package com.heartstone.cartas.domain.model;

public enum Tipo {
	
	MAGIA("Magia"), CRIATURA("Criatura");
	
	private String descricao;

	Tipo(String descricao) {
		this.descricao = descricao;
	}

	public static Tipo obterPorDescricao(String descricao) {
		for (Tipo e : Tipo.values()) {
			if (descricao.equals(e.getDescricao().toUpperCase()))
				return e;
		}
		return null;
	}

	public String getDescricao() {
		return descricao;
	}
}
