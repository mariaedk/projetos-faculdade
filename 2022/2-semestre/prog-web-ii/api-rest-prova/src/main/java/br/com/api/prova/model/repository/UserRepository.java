package br.com.api.prova.model.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.api.prova.model.entity.Usuario;

@Repository
public interface UserRepository extends JpaRepository<Usuario, Integer>
{
	Optional<Usuario> findByUsuario(String username);
}
