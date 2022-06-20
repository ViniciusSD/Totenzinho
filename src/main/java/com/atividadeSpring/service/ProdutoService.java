package com.atividadeSpring.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.atividadeSpring.entities.Produto;
import com.atividadeSpring.exception.JpaObjectRetrievalFailureException;
import com.atividadeSpring.exception.ObjectNotFoundException;
import com.atividadeSpring.repositories.ProdutoRepository;

@Service
public class ProdutoService {

	final ProdutoRepository produtoRepo;

	public ProdutoService(ProdutoRepository produtoRepo) {
		this.produtoRepo = produtoRepo;
	}

	public Produto save(Produto produto) {
		produto.setId(null);
		return produtoRepo.save(produto);
	}

	public List<Produto> find() {
		return produtoRepo.findAll();
	}

	public Produto findById(Integer id) {
		Optional<Produto> produto = produtoRepo.findById(id);
		return produto.orElseThrow(() -> new ObjectNotFoundException("ID Não possui nenhum cadastro vinculado !!"));
	}

	public void delete(Integer id) {
		produtoRepo.deleteById(id);
	}

//	public Produto update(Integer id, Produto produto) {
//		produto.setId(id);
//		Produto oldObj = findById(id);
//
//		oldObj = new Produto(produto);
//		return produtoRepo.save(oldObj);
//	}

	public Produto put(Produto produton) {

		try {
			produtoRepo.save(produton);

		} catch (JpaObjectRetrievalFailureException e) {
			throw new JpaObjectRetrievalFailureException("Não foi possivel Alterar, pois o campo nome não existe !!");
		}
		return null;
	}

}
