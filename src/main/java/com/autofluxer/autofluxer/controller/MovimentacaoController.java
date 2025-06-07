package com.autofluxer.autofluxer.controller;

import com.autofluxer.autofluxer.model.Movimentacao;
import com.autofluxer.autofluxer.service.MovimentacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@RestController
@RequestMapping("/api/movimentacoes")
public class MovimentacaoController {

    private static final Logger logger = LogManager.getLogger(MovimentacaoController.class);

    @Autowired
    private MovimentacaoService movimentacaoService;

    @GetMapping
    public List<Movimentacao> listarTodas() {
        logger.info("listando todas movimentacoes");
        return movimentacaoService.listarTodas();
    }

    @GetMapping("/{id}")
    public Optional<Movimentacao> buscarPorId(@PathVariable Long id) {
        logger.info("buscando movimentacoes por ID: {}", id);
        return movimentacaoService.buscarPorId(id);
    }

    @PostMapping
    public Movimentacao cadastrar(@RequestBody Movimentacao movimentacao) {
        logger.info("movimentacao cadastrada. {}",movimentacao);
        return movimentacaoService.salvar(movimentacao);
    }

    @DeleteMapping("/{id}")
    public String deletar(@PathVariable Long id) {
        logger.warn("deletando movimentacao por ID: {}", id);
        movimentacaoService.deletar(id);
        logger.info("movimentacao deletada com sucesso, ID: {}",id);
        return "Movimentação com ID " + id + " foi deletada com sucesso!";
    }
}
