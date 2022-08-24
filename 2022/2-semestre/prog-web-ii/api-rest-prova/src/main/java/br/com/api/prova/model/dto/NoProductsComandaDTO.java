package br.com.api.prova.model.dto;

import java.io.Serializable;

public class NoProductsComandaDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	private Integer idUsuario;
	private String nomeUsuario;
	private String telefoneUsuario;
	
	
	public NoProductsComandaDTO() {}
	
	public NoProductsComandaDTO(Integer idUsuario, String nomeUsuario, String telefoneUsuario) {
		super();
		this.idUsuario = idUsuario;
		this.nomeUsuario = nomeUsuario;
		this.telefoneUsuario = telefoneUsuario;
	}
	public Integer getIdUsuario() {
		return idUsuario;
	}
	public void setIdUsuario(Integer idUsuario) {
		this.idUsuario = idUsuario;
	}
	public String getNomeUsuario() {
		return nomeUsuario;
	}
	public void setNomeUsuario(String nomeUsuario) {
		this.nomeUsuario = nomeUsuario;
	}
	public String getTelefoneUsuario() {
		return telefoneUsuario;
	}
	public void setTelefoneUsuario(String telefoneUsuario) {
		this.telefoneUsuario = telefoneUsuario;
	}
	
	
}
