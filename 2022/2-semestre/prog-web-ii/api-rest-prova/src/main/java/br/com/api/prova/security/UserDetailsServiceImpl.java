package br.com.api.prova.security;

import java.util.Optional;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import br.com.api.prova.model.entity.Usuario;
import br.com.api.prova.model.repository.UserRepository;

@Component
public class UserDetailsServiceImpl implements UserDetailsService
{
    private final UserRepository repository;

    public UserDetailsServiceImpl(UserRepository repository) {
        this.repository = repository;
    }
	@Override
	// recebe um username e busca na base de dados qual o usuario correspondente
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException 
	{
		Optional<Usuario> usuario = repository.findByUsuario(username);
 
		if (usuario.isEmpty())
		{
			throw new UsernameNotFoundException("Usuário nao encontrado");
		}
		
		return new DetalheUsuarioData(usuario);
	}

}
