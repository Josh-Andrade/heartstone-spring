package com.hearstone.cartas.domain.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hearstone.cartas.domain.model.Carta;

@Repository
public interface CartaRepository extends JpaRepository<Carta, Integer> {

	Optional<Carta> findByNome(String nome);
	List<Carta> findAllByNome(String nome);
	Optional<Carta> findById(Integer id);
	Optional<Carta> findByClasse(String classe);
	Optional<Carta> findByTipo(String tipo);
}
