package com.heartstone.cartas.domain.especification;

import com.heartstone.cartas.api.model.CartaInput;
import com.heartstone.cartas.domain.model.Carta;
import com.heartstone.cartas.domain.model.Classe;
import com.heartstone.cartas.domain.model.Tipo;

import java.util.Objects;

import org.springframework.data.jpa.domain.Specification;

public class CartaSpecification {

    public static Specification<Carta> comParametros(CartaInput parametros) {
        Specification<Carta> specification = Specification.where(null);
        if (Objects.nonNull(parametros.getNome()))
        	specification = specification.and(comNome(parametros.getNome()));
        if (Objects.nonNull(parametros.getClasse()))
        	specification = specification.and(comClasse(parametros.getClasse()));
        if (Objects.nonNull(parametros.getTipo()))
        	specification = specification.and(comTipo(parametros.getTipo()));
        return specification;
    }

    private static Specification<Carta> comNome(String nome) {
        return (root, query, criteriaBuilder)
                -> criteriaBuilder.like(criteriaBuilder.upper(root.get("nome")), "%" + nome.toUpperCase() + "%");
    }

    private static Specification<Carta> comTipo(String tipo) {
        return (root, query, criteriaBuilder)
                -> criteriaBuilder.equal(root.get("tipo"), Tipo.obterPorDescricao(tipo.toUpperCase()));
    }

    private static Specification<Carta> comClasse(String classe) {
        return (root, query, criteriaBuilder)
                -> criteriaBuilder.equal(root.get("classe"), Classe.obterPorDescricao(classe.toUpperCase()));
    }
}
