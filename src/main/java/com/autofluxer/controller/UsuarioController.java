package com.autofluxer.controller;

import com.autofluxer.model.Usuario;
import com.autofluxer.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {

    private static final Logger logger = LogManager.getLogger(UsuarioController.class);

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping
    public List<Usuario> listarTodos() {
        logger.info("listando todos os usuarios");
        return usuarioService.listarTodos();
    }

    @GetMapping("/{id}")
    public Optional<Usuario> buscarPorId(@PathVariable Long id) {
        logger.info("buscando usuario por ID: {}", id);
        return usuarioService.buscarPorId(id);
    }

    @PostMapping
    public Usuario cadastrar(@RequestBody Usuario usuario) {
        logger.info("usuario cadastrado.  {}", usuario);
        return usuarioService.salvar(usuario);
    }

    @PutMapping("/{id}")
    public Usuario atualizar(@PathVariable Long id, @RequestBody Usuario usuarioAtualizado) {
        logger.info("atualizacao de usuario com ID: {}", id);
        Optional<Usuario> usuarioExistente = usuarioService.buscarPorId(id);
        if (usuarioExistente.isPresent()) {
            logger.info("usuario atualizado com sucesso");
            usuarioAtualizado.setIdUsuario(id);
            return usuarioService.atualizar(usuarioAtualizado);
        } else {
            logger.warn("erro na atualizacao do usuario com ID: {}", id);
            throw new RuntimeException("Usuário não encontrado com ID: " + id);
        }
    }

    @DeleteMapping("/{id}")
    public String deletar(@PathVariable Long id) {
        logger.warn("deletando cliente por ID: {}", id);
        usuarioService.deletar(id);
        logger.info("usuario deletado com sucesso. ID: {}", id);
        return "Usuário com ID " + id + " foi deletado com sucesso!";
    }
}
