package br.com.api.prova.model.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import br.com.api.prova.model.dto.ComandaDTO;
import br.com.api.prova.model.dto.ProdutoDTO;

@Entity
@Table(name = "comandas")
public class Comanda 
{
	@Id
	private Integer idUsuario;
	@Column(length = 60)
	private String nomeUsuario;
	@Column(length = 16)
	private String telefoneUsuario;
	@OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "produto_id")
	private List<Produto> produtos = new ArrayList<>();
	
	public ComandaDTO getDTO() 
	{
		return new ComandaDTO(this.getIdUsuario(), this.getNomeUsuario(), this.getTelefoneUsuario(), this.convertProdutosEntityToDTO());
	}

	public List<ProdutoDTO> convertProdutosEntityToDTO() 
	{
		return this.produtos.stream().map(
			produto -> {
				return new ProdutoDTO(produto.getId(), produto.getNome(), produto.getPreco());
			}
		).collect(Collectors.toList());
	}

	public Comanda(Integer idUsuario, String nomeUsuario, String telefoneUsuario, List<Produto> produtos) {
		this.setIdUsuario(idUsuario);
		this.setNomeUsuario(nomeUsuario);
		this.setTelefoneUsuario(telefoneUsuario);
		this.setProdutos(produtos);
	}
	
	public Comanda(Integer idUsuario, String nomeUsuario, String telefoneUsuario) {
		this.setIdUsuario(idUsuario);
		this.setNomeUsuario(nomeUsuario);
		this.setTelefoneUsuario(telefoneUsuario);
	}

	public Comanda() {}

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

	public List<Produto> getProdutos() {
		return produtos;
	}

	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}
}
