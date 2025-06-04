package com.autofluxer.controller;

import com.autofluxer.model.Usuario;
import com.autofluxer.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping
    public List<Usuario> listarTodos() {
        return usuarioService.listarTodos();
    }

    @GetMapping("/{id}")
    public Optional<Usuario> buscarPorId(@PathVariable Long id) {
        return usuarioService.buscarPorId(id);
    }

    @PostMapping
    public Usuario cadastrar(@RequestBody Usuario usuario) {
        return usuarioService.salvar(usuario);
    }

    @PutMapping("/{id}")
    public Usuario atualizar(@PathVariable Long id, @RequestBody Usuario usuarioAtualizado) {
        Optional<Usuario> usuarioExistente = usuarioService.buscarPorId(id);
        if (usuarioExistente.isPresent()) {
            usuarioAtualizado.setIdUsuario(id);
            return usuarioService.atualizar(usuarioAtualizado);
        } else {
            throw new RuntimeException("Usuário não encontrado com ID: " + id);
        }
    }

    @DeleteMapping("/{id}")
    public String deletar(@PathVariable Long id) {
        usuarioService.deletar(id);
        return "Usuário com ID " + id + " foi deletado com sucesso!";
    }
}
