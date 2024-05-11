package com.si.mensagem.cadastrousuario.controller;

import com.si.mensagem.cadastrousuario.service.UsuarioService;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import com.si.mensagem.cadastrousuario.pojo.UsuarioPojo;

@Controller
public class UsuarioController {

    @Autowired
    UsuarioService usuarioService;

    @GetMapping("/cadastro")
    public String mostrarFormularioCadastro(@NotNull Model model) {
        model.addAttribute("usuarioPojo", new UsuarioPojo());
        return "cadastroUsuario";
    }

    @PostMapping("/api/usuarios/criar")
    public String criarUsuario(@ModelAttribute UsuarioPojo usuarioPojo, @NotNull Model model) {
        // Chamar o método desejado e receber o retorno
        String resultado = usuarioService.autenticarUsuario(usuarioPojo);
        // Adicionar o retorno ao modelo
        model.addAttribute("resultado", resultado);
        return "senhaResumida";
    }
}