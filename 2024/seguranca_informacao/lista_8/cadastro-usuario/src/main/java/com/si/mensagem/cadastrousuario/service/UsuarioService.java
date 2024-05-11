package com.si.mensagem.cadastrousuario.service;

import com.si.mensagem.cadastrousuario.entity.UsuarioEntity;
import com.si.mensagem.cadastrousuario.entity.UsuarioRepository;
import com.si.mensagem.cadastrousuario.pojo.UsuarioPojo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;
import java.security.NoSuchAlgorithmException;

@Service
public class UsuarioService {

    private static final String INSERIDO = "Usuário cadastrado com sucesso";
    private static final String LOGADO = "Usuário logado com sucesso";
    private static final String FALHA = "Falha ao autenticar o usuário";
    private static final String FALHA_CADASTRO = "Falha ao cadastrar o usuário";

    @Autowired
    private UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public String autenticarUsuario(UsuarioPojo usuarioPojo) {
         UsuarioEntity usuario = usuarioRepository.findByUsuario(usuarioPojo.getLogin());
         return usuario != null ? validaLogin(usuarioPojo.getLogin(), usuarioPojo.getSenha()) : cadastrar(usuarioPojo.getLogin(), usuarioPojo.getSenha());
    }

    private String validaLogin(String login, String senha) {
        return autenticado(login, senha) ? LOGADO : FALHA;
    }

    private String cadastrar(String login, String senha) {
        try {
            criarNovoUsuario(login, senha);
            return INSERIDO;
        } catch (Exception e) {
            return FALHA_CADASTRO;
        }
    }

    /**
     * Cria um novo usuário no banco
     */
    private void criarNovoUsuario(String login, String senha) throws NoSuchAlgorithmException {
        UsuarioEntity entity = new UsuarioEntity();

        byte[] saltUsuario = SenhaHashService.gerarSalt();
        byte[] senhaUsuario = SenhaHashService.hashSenha(senha, saltUsuario);

        //gera o salt e converte em string
        entity.setSalt(saltUsuario);
        //gera a senha baseado no salt
        entity.setSenha(senhaUsuario);
        //seta o usuario
        entity.setUsuario(login);

        usuarioRepository.save(entity);
    }

    private Boolean autenticado(String login, String senha) {
        try {
            //busca no banco o salt do usuario
            byte[] saltBanco = usuarioRepository.buscaSalt(login);
            //busca no banco o hash do usuario
            byte[] hashBanco = usuarioRepository.buscaHashSenha(login);

            //compara se a senha bate com o hash no banco
            return SenhaHashService.verificarSenha(senha, saltBanco, hashBanco);

        } catch (Exception e) {
            return false;
        }
    }

}
