package com.atividadeSpring.entities;

import java.math.BigDecimal;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "PRODUTO")
public class Produto {

	@ManyToOne
	private Carrinho carrinho;

	@GeneratedValue(strategy = GenerationType.AUTO)
	@Id
	private Integer id;

	private String nome;

	private BigDecimal preco;

	private String departamento;

	public Carrinho getCarrinho() {
		return carrinho;
	}

	public void setCarrinho(Carrinho carrinho) {
		this.carrinho = carrinho;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public BigDecimal getPreco() {
		return preco;
	}

	public void setPreco(BigDecimal preco) {
		this.preco = preco;
	}

	public String getDepartamento() {
		return departamento;
	}

	public void setDepartamento(String departamento) {
		this.departamento = departamento;
	}

	@Override
	public int hashCode() {
		return Objects.hash(carrinho, departamento, id, nome, preco);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Produto other = (Produto) obj;
		return Objects.equals(carrinho, other.carrinho) && Objects.equals(departamento, other.departamento)
				&& Objects.equals(id, other.id) && Objects.equals(nome, other.nome)
				&& Objects.equals(preco, other.preco);
	}

	@Override
	public String toString() {
		return "Produto [carrinho=" + carrinho + ", id=" + id + ", nome=" + nome + ", preco=" + preco
				+ ", departamento=" + departamento + "]";
	}

	public Produto(Carrinho carrinho, Integer id, String nome, BigDecimal preco, String departamento) {
		super();
		this.carrinho = carrinho;
		this.id = id;
		this.nome = nome;
		this.preco = preco;
		this.departamento = departamento;
	}

	public Produto() {
		super();
	
	}

}
