package com.autofluxer.controller;

import com.autofluxer.model.Movimentacao;
import com.autofluxer.service.MovimentacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/movimentacoes")
public class MovimentacaoController {

    @Autowired
    private MovimentacaoService movimentacaoService;

    @GetMapping
    public List<Movimentacao> listarTodas() {
        return movimentacaoService.listarTodas();
    }

    @GetMapping("/{id}")
    public Optional<Movimentacao> buscarPorId(@PathVariable Long id) {
        return movimentacaoService.buscarPorId(id);
    }

    @PostMapping
    public Movimentacao cadastrar(@RequestBody Movimentacao movimentacao) {
        return movimentacaoService.salvar(movimentacao);
    }

    @DeleteMapping("/{id}")
    public String deletar(@PathVariable Long id) {
        movimentacaoService.deletar(id);
        return "Movimentação com ID " + id + " foi deletada com sucesso!";
    }
}
