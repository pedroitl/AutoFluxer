package com.autofluxer.controller;

import com.autofluxer.service.AutenticacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")

public class AutenticacaoController {

    @Autowired
    private AutenticacaoService autenticacaoService;

    @PostMapping("/login")
    public String login(@RequestParam String email, @RequestParam String senha) {
        boolean autenticado = autenticacaoService.autenticar(email, senha);

        if (autenticado) {
            return "Login realizado com sucesso!";
        } else {
            return "Email ou senha inválidos.";
        }
    }
}
