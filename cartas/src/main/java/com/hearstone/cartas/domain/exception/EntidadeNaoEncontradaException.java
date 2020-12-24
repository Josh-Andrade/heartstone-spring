package com.hearstone.cartas.domain.exception;

public class EntidadeNaoEncontradaException extends BaralhoException {

	private static final long serialVersionUID = 1L;

	public EntidadeNaoEncontradaException(String mensagem) {
		super(mensagem);
	}
}
