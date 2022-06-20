package com.atividadeSpring.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.atividadeSpring.entities.Carrinho;
import com.atividadeSpring.repositories.CarrinhoRepository;
import com.atividadeSpring.service.CarrinhoService;

@RestController
@RequestMapping(value = "/carrinho")
@CrossOrigin("*")
public class CarrinhoController {

	@Autowired
	private final CarrinhoService carrServ;

	@Autowired
	private final CarrinhoRepository carrRepo;

	public CarrinhoController(CarrinhoService carrServ, CarrinhoRepository carrRepo) {
		this.carrServ = carrServ;
		this.carrRepo = carrRepo;
	}

	@PostMapping
	public ResponseEntity<Carrinho> Criar(@RequestBody Carrinho carrinho) {
		Carrinho obj = carrServ.save(carrinho);
		return ResponseEntity.ok().body(obj);
	}

	@GetMapping
	public ResponseEntity<List<Carrinho>> buscarTodos() {
		List<Carrinho> carrinhos = carrRepo.findAll();
		return ResponseEntity.ok().body(carrinhos);
	}

	@GetMapping("/{id}")
	public Optional<Carrinho> BuscaPorId(@PathVariable Integer id) {
		return Optional.ofNullable(carrServ.findById(id));
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Carrinho> Apagar(@PathVariable Integer id) {
		BuscaPorId(id);
		carrServ.delete(id);
		return ResponseEntity.noContent().build();
	}

	@PutMapping
	public Carrinho atualizar(@RequestBody Carrinho carrinhon) {
		return carrRepo.save(carrinhon);
	}

}
