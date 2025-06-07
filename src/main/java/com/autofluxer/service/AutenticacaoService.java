package com.autofluxer.service;

import com.autofluxer.model.Usuario;
import com.autofluxer.repositorio.UsuarioRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Service
public class AutenticacaoService {

    private static final Logger logger = LogManager.getLogger(AutenticacaoService.class);

    @Autowired
    private UsuarioRepositorio usuarioRepositorio;

    public boolean autenticar(String email, String senha) {
        logger.info("tentativa de login com email: {}", email);
        Optional<Usuario> usuario = usuarioRepositorio.findByEmail(email);

        if (usuario.isPresent()) {
            logger.info("tentativa bem-sucessida para o email: {}", email);
            return usuario.get().getSenha().equals(senha);
        } else {
            logger.warn("tentativa de login falhou para o email: {}", email);
            return false;
        }
    }
}
