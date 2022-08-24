package br.com.api.prova.model.dto;

import java.io.Serializable;

import br.com.api.prova.model.entity.Produto;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "ProdutoDTO")
public class ProdutoDTO  implements Serializable
{
	private static final long serialVersionUID = 1L;
	@ApiModelProperty(value = "Id do produto. Deve ser informado pois não é gerado pelo banco.")
	private Integer id;
	private String nome;
	private Double preco;	

	public Produto convertToEntity()
	{
		return new Produto(this.getId(), this.getNome(), this.getPreco());
	}

	public ProdutoDTO() {}

	public ProdutoDTO(Integer id, String nome, Double preco) {
		this.setId(id);
		this.setNome(nome);
		this.setPreco(preco);
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
