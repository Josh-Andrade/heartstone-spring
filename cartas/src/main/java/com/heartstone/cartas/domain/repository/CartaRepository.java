package com.heartstone.cartas.domain.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.heartstone.cartas.domain.model.Carta;

@Repository
public interface CartaRepository extends JpaRepository<Carta, Integer>, JpaSpecificationExecutor<Carta> {

	List<Carta> findAllByNome(String nome);
	
	List<Carta> findAllByNomeAndIdNot(String nome, Integer id);
}
