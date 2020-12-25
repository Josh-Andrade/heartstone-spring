package com.heartstone.cartas.domain.model;

public enum Classe {

	MAGO("Mago"), PALADINO("Paladino"), CACADOR("Caçador"), DRUIDA("Druida"), QUALQUER("Qualquer");

	private String descricao;

	Classe(String descricao) {
		this.descricao = descricao;
	}

	public static Classe valueOfByName(String name) {
		return valueOf(name.toUpperCase());
	}

	public static Classe obterPorDescricao(String descricao) {
		for (Classe e : Classe.values()) {
			if (descricao.equals(e.getDescricao().toUpperCase()))
				return e;
		}
		return null;
	}

	public String getDescricao() {
		return descricao;
	}
	
	
}
