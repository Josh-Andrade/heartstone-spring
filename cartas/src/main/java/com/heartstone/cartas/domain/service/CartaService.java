package com.heartstone.cartas.domain.service;

import java.util.List;

import com.heartstone.cartas.api.model.CartaInput;
import com.heartstone.cartas.domain.model.Carta;

public interface CartaService {
	
	Carta cadastrar(Carta carta);
	
	List<Carta> consultar(CartaInput cartaInput);
	
	Carta atualizar(Integer id, Carta carta);
	
	void deletar(Integer id);
	
	Carta buscarPorId(Integer id);
}
