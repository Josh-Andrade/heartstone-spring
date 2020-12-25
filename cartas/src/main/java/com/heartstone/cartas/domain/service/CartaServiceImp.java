package com.heartstone.cartas.domain.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.heartstone.cartas.api.model.CartaInput;
import com.heartstone.cartas.domain.exception.BaralhoException;
import com.heartstone.cartas.domain.exception.EntidadeNaoEncontradaException;
import com.heartstone.cartas.domain.model.Carta;
import com.heartstone.cartas.domain.repository.CartaRepository;

import static com.heartstone.cartas.domain.especification.CartaSpecification.comParametros;
import static com.heartstone.cartas.domain.util.Constantes.ENTIDADE_NAO_ENCONTRADA;

@Service
public class CartaServiceImp implements CartaService {

	private CartaRepository cartaRepository;

	public CartaServiceImp(CartaRepository cartaRepository) {
		this.cartaRepository = cartaRepository;
	}

	@Override
	public Carta cadastrar(Carta carta) {
		verificarSeExisteDuasCartas(cartaRepository.findAllByNome(carta.getNome()));
		verificarAtaqueEhDefesa(carta.getAtaque(), carta.getDefesa());
		return cartaRepository.save(carta);
	}

	@Override
	public List<Carta> consultar(CartaInput cartaInput) {
		return cartaRepository.findAll(comParametros(cartaInput));
	}

	@Override
	public Carta atualizar(Integer id, Carta carta) {
		cartaRepository.findById(id).orElseThrow(() -> new EntidadeNaoEncontradaException(ENTIDADE_NAO_ENCONTRADA));
		verificarSeExisteDuasCartas(cartaRepository.findAllByNomeAndIdNot(carta.getNome(), id));
		verificarAtaqueEhDefesa(carta.getAtaque(), carta.getDefesa());
		carta.setId(id);
		return cartaRepository.save(carta);
	}

	@Override
	public void deletar(Integer id) {
		cartaRepository.findById(id).orElseThrow(() -> new EntidadeNaoEncontradaException(ENTIDADE_NAO_ENCONTRADA));
		cartaRepository.deleteById(id);
	}

	@Override
	public Carta buscarPorId(Integer id) {
		Optional<Carta> carta = cartaRepository.findById(id);
		if(carta.isPresent()) {
			return carta.get();
		}else {
			throw new EntidadeNaoEncontradaException(ENTIDADE_NAO_ENCONTRADA);
		}
	}

	private Boolean validarAtaque(Integer ataque) {
		return ataque <= 10 && ataque >= 0;
	}

	private Boolean validarDefesa(Integer defesa) {
		return defesa <= 10 && defesa >= 0;
	}

	private void verificarAtaqueEhDefesa(Integer ataque, Integer defesa) {
		if (!validarAtaque(ataque) || !validarDefesa(defesa)) {
			throw new BaralhoException("Valor de ataque ou defesa invalidos");
		}
	}

	private void verificarSeExisteDuasCartas(List<Carta> cartas) {
		if (cartas.size() >= 2) {
			throw new BaralhoException("Já existem duas cartas com esse nome cadastradas");
		}
	}

}
