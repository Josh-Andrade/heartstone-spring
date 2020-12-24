package com.hearstone.cartas.domain.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hearstone.cartas.domain.exception.BaralhoException;
import com.hearstone.cartas.domain.model.Carta;
import com.hearstone.cartas.domain.repository.CartaRepository;

@Service
public class CartaService {

	@Autowired
	private CartaRepository cartaRepository;
	
	public Carta cadastrar(Carta carta) {
		List<Carta> cartasIguais = cartaRepository.findAllByNome(carta.getNome());
		
		if(cartasIguais.size() >= 2) {
			throw new BaralhoException("Já existem duas cartas com esse nome cadastradas");
		}else if (!validarAtaque(carta.getAtaque()) || !validarDefesa(carta.getDefesa())) {
			throw new BaralhoException("Valor de ataque ou defesa invalidos");
		}
		return cartaRepository.save(carta);
	}
	
	public void excluir(Integer id) {
		cartaRepository.deleteById(id);
	}
	
	private Boolean validarAtaque(Integer ataque) {
		return ataque <= 10 && ataque >= 0;
	}

	private Boolean validarDefesa(Integer defesa) {
		return defesa <= 10 && defesa >= 0;
	}
}
