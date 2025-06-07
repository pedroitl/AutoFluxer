package com.autofluxer.service;

import com.autofluxer.model.Usuario;
import com.autofluxer.repositorio.UsuarioRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Service

public class UsuarioService {

    private static final Logger logger = LogManager.getLogger(UsuarioService.class);
    @Autowired
    private UsuarioRepositorio usuarioRepositorio;

    public List<Usuario> listarTodos() {
        logger.info("listando todos os usuarios");
        return usuarioRepositorio.findAll();
    }

    public Optional<Usuario> buscarPorId(Long id) {
        logger.info("buscando usuario por ID: {}", id);
        return usuarioRepositorio.findById(id);
    }

    public Optional<Usuario> buscarPorEmail(String email) {
        logger.info("buscando usuario por email: {}", email);
        return usuarioRepositorio.findByEmail(email);
    }

    public Usuario salvar(Usuario usuario) {
        logger.info("salvando um novo usuario. {}", usuario);
        return usuarioRepositorio.save(usuario);
    }

    public Usuario atualizar(Usuario usuario) {
        logger.info("atualizando usuario. {}", usuario);
        return usuarioRepositorio.save(usuario);
    }

    public void deletar(Long id) {
        logger.warn("deletando usuario por ID: {}", id);
        usuarioRepositorio.deleteById(id);
        logger.info("usuario deletado com sucesso. {}", id);
    }
}
