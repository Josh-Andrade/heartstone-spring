package com.hearstone.cartas.domain.model;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
public class Carta {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@NotBlank
	@Size(max = 60)
	private String nome;
	@NotBlank
	@Size(max = 200)
	private String descricao;
	
	private Integer ataque;
	private Integer defesa;
	@Enumerated(EnumType.STRING)
	private Tipo tipo;
	@Enumerated(EnumType.STRING)
	private Classe classe;
	
	
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getDescricao() {
		return descricao;
	}
	
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public Integer getAtaque() {
		return ataque;
	}
	
	public void setAtaque(Integer ataque) {
		this.ataque = ataque;
	}
	
	public Integer getDefesa() {
		return defesa;
	}
	
	public void setDefesa(Integer defesa) {
		this.defesa = defesa;
	}
	
	public Tipo getTipo() {
		return tipo;
	}
	
	public void setTipo(Tipo tipo) {
		this.tipo = tipo;
	}
	
	public Classe getClasse() {
		return classe;
	}
	
	public void setClasse(Classe classe) {
		this.classe = classe;
	}
	
	
}
