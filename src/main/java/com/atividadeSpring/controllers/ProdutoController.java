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

import com.atividadeSpring.entities.Produto;
import com.atividadeSpring.service.ProdutoService;

@RestController
@RequestMapping(value = "/produto")
@CrossOrigin("*")
public class ProdutoController {

	@Autowired
	private final ProdutoService prodServ;

	public ProdutoController(ProdutoService prodServ) {
		this.prodServ = prodServ;
	}

	@GetMapping
	public List<Produto> BuscarTodosOsProdutos() {
		return prodServ.find();
	}
	
	@GetMapping("/{id}")
	public Optional<Produto> BuscaPorId(@PathVariable Integer id) {
		return Optional.ofNullable(prodServ.findById(id));
	}

	@PostMapping
	public ResponseEntity<Produto> CriarProduto(@RequestBody Produto produto) {
		Produto obj = prodServ.save(produto);
		return ResponseEntity.ok().body(obj);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Produto> ApagarProduto(@PathVariable Integer id) {
		BuscaPorId(id);
		prodServ.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	@PutMapping
	public Produto atualizar(@RequestBody Produto produton) {
		return prodServ.put(produton);
	}  

}
