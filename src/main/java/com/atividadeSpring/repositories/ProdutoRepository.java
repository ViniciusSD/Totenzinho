package com.atividadeSpring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.atividadeSpring.entities.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Integer>{

}
