package com.heartstone.cartas.api.controller;

import java.util.List;

import javax.validation.Valid;

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

import com.heartstone.cartas.api.model.CartaInput;
import com.heartstone.cartas.domain.model.Carta;
import com.heartstone.cartas.domain.service.CartaServiceImp;

@RestController
@RequestMapping("/carta")
public class CartaController {
	
	private CartaServiceImp cartaService;
	
	public CartaController(CartaServiceImp cartaService) {
		this.cartaService = cartaService;
	}

	@GetMapping("/{id}")
	public ResponseEntity<Carta> buscarPorId(@PathVariable Integer id){
		Carta cartaConsultada = cartaService.buscarPorId(id);
		return ResponseEntity.ok(cartaConsultada);
	}
	
	@PostMapping("/consultar")
	public ResponseEntity<List<Carta>> consultar(@RequestBody CartaInput cartaInput){
		List<Carta> cartasConsultadas = cartaService.consultar(cartaInput);
		return ResponseEntity.ok(cartasConsultadas);
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Carta cadastrarNovaCarta(@Valid @RequestBody Carta carta) {
		return cartaService.cadastrar(carta);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Carta> atualizar(@Valid @PathVariable Integer id
			, @RequestBody Carta carta) {
		carta = cartaService.atualizar(id ,carta);
		return ResponseEntity.ok(carta);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deletar(@Valid @PathVariable Integer id){
		cartaService.deletar(id);
		return ResponseEntity.noContent().build();
	}
}
