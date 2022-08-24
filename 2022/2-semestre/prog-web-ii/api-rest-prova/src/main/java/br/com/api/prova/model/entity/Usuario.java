package br.com.api.prova.model.entity;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

@Entity
@Table(name = "usuarios")
public class Usuario implements Serializable
{

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idUsuario;
    private String usuario;
    private String senha;
    
    public Usuario() {}

    public Usuario(int idUsuario, String usuario, String senha) {
		super();
		this.setIdUsuario(idUsuario);
		this.setSenha(senha);
		this.setUsuario(usuario);
	}

	public Integer getIdUsuario() {
        return idUsuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
		if (!senha.isEmpty() && senha.length() > 0)
		{			
			this.senha = senha;
		}
		else
		{
			throw new IllegalArgumentException("Senha não pode ser nula.");
		}
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
		if (!usuario.isEmpty() && usuario.length() > 0)
		{			
			this.usuario = usuario;
		}
		else
		{
			throw new IllegalArgumentException("Usuario não pode ser nulo.");
		}
    }

    public void setIdUsuario(int idUsuario) {
		if (idUsuario >= 0)
		{
			this.idUsuario = idUsuario;
		}
		else
		{
			throw new IllegalArgumentException("Id não pode ser nulo");
		}
    }
}
