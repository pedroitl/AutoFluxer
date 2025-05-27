package com.autofluxer.service;

import com.autofluxer.model.Usuario;
import com.autofluxer.repository.UsuarioRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AutenticacaoService {

    @Autowired
    private UsuarioRepositorio usuarioRepositorio;

    public boolean autenticar(String email, String senha) {
        Optional<Usuario> usuario = usuarioRepositorio.findByEmail(email);

        if (usuario.isPresent()) {
            return usuario.get().getSenha().equals(senha);
        } else {
            return false;
        }
    }
}
