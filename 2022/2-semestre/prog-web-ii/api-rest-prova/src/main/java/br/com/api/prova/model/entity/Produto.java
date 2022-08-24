package br.com.api.prova.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import br.com.api.prova.model.dto.ProdutoDTO;

@Entity
@Table(name = "produtos")
public class Produto 
{
	@Id
	private Integer id;
	@Column(length = 40)
	private String nome;
	private Double preco;	

	public Produto() {}

	public Produto(Integer id, String nome, Double preco) {
		this.setId(id);
		this.setNome(nome);
		this.setPreco(preco);
	}

	public ProdutoDTO getDTO()
	{
		return new ProdutoDTO(this.getId(), this.getNome(), this.getPreco());
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		if (id > 0)
		{			
			this.id = id;
		}
		else
		{			
			throw new IllegalArgumentException("Id deve ser maior do que 0.");
		}
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		if (!nome.isEmpty() && nome.length() > 0)
		{			
			this.nome = nome;
		}
		else
		{
			throw new IllegalArgumentException("Nome não pode ser nulo.");
		}
	}

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		if (preco >= 0)
		{
			this.preco = preco;
		}
		else
		{
			throw new IllegalArgumentException("Preço não pode ser negativo");
		}
	}
	
}
