package com.autofluxer.controller;

import com.autofluxer.service.AutenticacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@RestController
@RequestMapping("/api/auth")

public class AutenticacaoController {

    private static final Logger logger = LogManager.getLogger(AutenticacaoController.class);

    @Autowired
    private AutenticacaoService autenticacaoService;

    @PostMapping("/login")
    public String login(@RequestParam String email, @RequestParam String senha) {
        logger.info("tentativa de login com o email: {}", email);
        boolean autenticado = autenticacaoService.autenticar(email, senha);

        if (autenticado) {
            logger.info("tentativa bem-sucedida para o email: {}", email);
            return "Login realizado com sucesso!";
        } else {
            logger.warn("Tentativa de login falhou para o e-mail: {}", email);
            return "Email ou senha inválidos.";
        }
    }
}
