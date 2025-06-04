package com.autofluxer.service;

import com.autofluxer.model.Usuario;
import com.autofluxer.repository.UsuarioRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service

public class UsuarioService {
    @Autowired
    private UsuarioRepositorio usuarioRepositorio;

    public List<Usuario> listarTodos() {
        return usuarioRepositorio.findAll();
    }

    public Optional<Usuario> buscarPorId(Long id) {
        return usuarioRepositorio.findById(id);
    }

    public Optional<Usuario> buscarPorEmail(String email) {
        return usuarioRepositorio.findByEmail(email);
    }

    public Usuario salvar(Usuario usuario) {
        return usuarioRepositorio.save(usuario);
    }

    public Usuario atualizar(Usuario usuario) {
        return usuarioRepositorio.save(usuario);
    }

    public void deletar(Long id) {
        usuarioRepositorio.deleteById(id);
    }
}
