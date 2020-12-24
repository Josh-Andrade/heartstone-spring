package com.hearstone.cartas.api.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.hearstone.cartas.domain.model.Carta;
import com.hearstone.cartas.domain.repository.CartaRepository;
import com.hearstone.cartas.domain.service.CartaService;

@RestController
@RequestMapping("/carta")
public class CartaController {

	@Autowired
	private CartaRepository cartaRepository;
	
	@Autowired
	private CartaService cartaService;
	
	@GetMapping
	public List<Carta> listarCartas(){
		return cartaRepository.findAll();
	}
	
	@GetMapping("/id/{id}")
	public ResponseEntity<Carta> buscarPorId(@PathVariable Integer id){
		Optional<Carta> carta = cartaRepository.findById(id);
		
		if(carta.isPresent()) {
			return ResponseEntity.ok(carta.get());
		}
		return ResponseEntity.notFound().build();
	}
	
	@GetMapping("/nome/{nome}")
	public ResponseEntity<Carta> buscarPorNome(@PathVariable String nome){
		Optional<Carta> carta = cartaRepository.findByNome(nome);
		
		if(carta.isPresent()) {
			return ResponseEntity.ok(carta.get());
		}
		return ResponseEntity.notFound().build();
	}
	
	@GetMapping("/tipo/{nome}")
	public ResponseEntity<Carta> buscarPorTipo(@PathVariable String tipo){
		Optional<Carta> carta = cartaRepository.findByTipo(tipo);
		if(carta.isPresent()) {
			return ResponseEntity.ok(carta.get());
		}
		return ResponseEntity.notFound().build();
	}
	
	@GetMapping("/classe/{nome}")
	public ResponseEntity<Carta> buscarPorClasse(@PathVariable String classe){
		Optional<Carta> carta = cartaRepository.findByTipo(classe);
		if(carta.isPresent()) {
			return ResponseEntity.ok(carta.get());
		}
		return ResponseEntity.notFound().build();
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Carta cadastrarNovaCarta(@Valid @RequestBody Carta carta) {
		return cartaService.cadastrar(carta);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Carta> atualizar(@Valid @PathVariable Integer id
			, @RequestBody Carta carta) {
		if(!cartaRepository.existsById(id)) {
			return ResponseEntity.notFound().build();
		}
		
		carta.setId(id);
		carta = cartaService.cadastrar(carta);
		
		return ResponseEntity.ok(carta);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deletar(@Valid @PathVariable Integer id){
		if (!cartaRepository.existsById(id)) {
			return ResponseEntity.notFound().build();
		}
		
		cartaService.excluir(id);
		
		return ResponseEntity.noContent().build();
	}
}