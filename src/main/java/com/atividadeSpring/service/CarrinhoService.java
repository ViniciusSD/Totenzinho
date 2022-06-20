package com.atividadeSpring.service;

import java.util.List;
import java.util.Optional;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.atividadeSpring.entities.Carrinho;
import com.atividadeSpring.exception.DataintegratyViolationException;
import com.atividadeSpring.exception.ObjectNotFoundException;
import com.atividadeSpring.repositories.CarrinhoRepository;

@Service
public class CarrinhoService {
	
	final CarrinhoRepository carrRepo;
	
	public CarrinhoService(CarrinhoRepository carrRepo) {
		this.carrRepo = carrRepo;
	}
	
	public Carrinho findById(Integer id) {
		Optional<Carrinho> carrinho = carrRepo.findById(id);
		return carrinho.orElseThrow(() -> new ObjectNotFoundException("ID Não possui nenhum cadastro vinculado !!"));
	}

	public List<Carrinho> find() {
		return carrRepo.findAll();
	}
	
	public Carrinho save(Carrinho carrinho) {
		carrinho.setId(null);
		return carrRepo.save(carrinho);
	}
	
	public void delete(Integer id) {
		try {
			carrRepo.deleteById(id);
		} catch(DataIntegrityViolationException d) {
			throw new DataintegratyViolationException("Não foi possivel deletar, pois possui itens no carrinho !!");
		    
		} 
	}
	
	

}
