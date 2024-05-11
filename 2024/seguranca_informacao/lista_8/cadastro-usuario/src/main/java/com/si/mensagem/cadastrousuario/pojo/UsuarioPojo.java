package com.si.mensagem.cadastrousuario.pojo;

public class UsuarioPojo {

    private Long id;
    private String login;
    private String senha;

    // Getters e setters
    public String getLogin() {
        return login;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}