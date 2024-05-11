package com.si.mensagem.cadastrousuario.entity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<UsuarioEntity, Long> {
    UsuarioEntity findByUsuario(String login);
    @Query("select u.salt from UsuarioEntity u where u.usuario = :login")
    byte[] buscaSalt(@Param("login") String login);

    @Query("select u.senha from UsuarioEntity u where u.usuario = :login")
    byte[] buscaHashSenha(@Param("login") String login);
}
