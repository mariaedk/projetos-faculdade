package br.com.api.prova.model.dto;

import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;

import br.com.api.prova.model.entity.Comanda;
import br.com.api.prova.model.entity.Produto;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "ComandaDTO")
public class ComandaDTO implements Serializable
{
	private static final long serialVersionUID = 1L;
	@ApiModelProperty(value = "Id do usuário. Deve ser informado pois não é gerado pelo banco.")
	private Integer idUsuario;
	private String nomeUsuario;
	private String telefoneUsuario;
	@ApiModelProperty(value = "Lista de produtos que uma comanda pode ter.")
	private List<ProdutoDTO> produtos;

	public Comanda convertToEntity()
	{
		return new Comanda(this.getIdUsuario(), this.getNomeUsuario(), this.getTelefoneUsuario(), this.convertProductsDTOtoEntity());	
	}
	
	public Comanda convertToEntityWithNoProduct()
	{
		return new Comanda(this.getIdUsuario(), this.getNomeUsuario(), this.getTelefoneUsuario());	
	}

	public List<Produto> convertProductsDTOtoEntity()
	{
		return this.produtos.stream().map(
			produto -> {
				return new Produto(produto.getId(), produto.getNome(), produto.getPreco());
			}
		).collect(Collectors.toList());
	}
	
	public List<ProdutoDTO> updateProdutos(List<ProdutoDTO> lista)
	{
		List<ProdutoDTO> produtosEntity = this.getProdutos();
		for (ProdutoDTO prod : produtosEntity)
		{
			for (ProdutoDTO prodRecebido : lista)
			{
				if (prod.getId().equals(prodRecebido.getId()))
				{
					prod.setNome(prodRecebido.getNome());
					prod.setPreco(prodRecebido.getPreco());
				}
			}
		}
		return produtosEntity;
	}

	public ComandaDTO(Integer idUsuario, String nomeUsuario, String telefoneUsuario, List<ProdutoDTO> produtos) {
		this.setIdUsuario(idUsuario);
		this.setNomeUsuario(nomeUsuario);
		this.setTelefoneUsuario(telefoneUsuario);
		this.setProdutos(produtos);
	}

	public ComandaDTO() {}

	public Integer getIdUsuario() {
		return idUsuario;
	}
	
	public void setIdUsuario(Integer idUsuario) {
		if (idUsuario > 0)
		{			
			this.idUsuario = idUsuario;
		}
		else
		{			
			throw new IllegalArgumentException("Id deve ser maior do que 0.");
		}
	}

	public String getNomeUsuario() {
		return nomeUsuario;
	}

	public void setNomeUsuario(String nomeUsuario) {
		if (!nomeUsuario.isEmpty() && nomeUsuario.length() > 0)
		{			
			this.nomeUsuario = nomeUsuario;
		}
		else
		{
			throw new IllegalArgumentException("Nome não pode ser nulo.");
		}
	}

	public String getTelefoneUsuario() {
		return telefoneUsuario;
	}

	public void setTelefoneUsuario(String telefoneUsuario) {
		if (!telefoneUsuario.isEmpty() && telefoneUsuario.length() > 0)
		{			
			this.telefoneUsuario = telefoneUsuario;
		}
		else
		{
			throw new IllegalArgumentException("Telefone não pode ser nulo.");
		}
	}

	public List<ProdutoDTO> getProdutos() {
		return produtos;
	}

	public void setProdutos(List<ProdutoDTO> produtos) {
		this.produtos = produtos;
	}

}
