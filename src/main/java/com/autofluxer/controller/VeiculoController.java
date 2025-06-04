package com.autofluxer.controller;

import com.autofluxer.model.Veiculo;
import com.autofluxer.repository.VeiculoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/veiculos")

public class VeiculoController {

    @Autowired
    private VeiculoRepositorio veiculoRepositorio;

    @GetMapping
    public List<Veiculo> listarTodos () {
        return veiculoRepositorio.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Veiculo> buscarPorId(@PathVariable long id) {
        return veiculoRepositorio.findById(id);
    }

    @PostMapping
    public Veiculo cadastrar(@RequestBody Veiculo veiculo) {
        return veiculoRepositorio.save(veiculo);
    }

    @PutMapping("/{id}")
    public Veiculo atualizar (@PathVariable long id, @RequestBody Veiculo veiculoAtualizado) {
        return veiculoRepositorio.findById(id)
                .map(veiculo -> {
                    veiculo.setMarca(veiculoAtualizado.getMarca());
                    veiculo.setModelo(veiculoAtualizado.getModelo());
                    veiculo.setAno(veiculoAtualizado.getAno());
                    veiculo.setCor(veiculoAtualizado.getCor());
                    veiculo.setPlaca(veiculoAtualizado.getPlaca());
                    veiculo.setChassi(veiculoAtualizado.getChassi());
                    veiculo.setRenavam(veiculoAtualizado.getRenavam());
                    veiculo.setTipo(veiculoAtualizado.getTipo());
                    veiculo.setStatus(veiculoAtualizado.getStatus());

                    return veiculoRepositorio.save(veiculo);
                })
                .orElseThrow(() -> new RuntimeException("Veículo não encontrado com o ID: " +id));

    }

    @DeleteMapping("/{id}")
    public String deletar(@PathVariable Long id) {
        veiculoRepositorio.deleteById(id);
        return "Veículo com ID "+id+ " foi deletado com sucesso!";
    }
}
