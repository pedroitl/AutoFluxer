package com.autofluxer.controller;

import com.autofluxer.model.Veiculo;
import com.autofluxer.repositorio.VeiculoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@RestController
@RequestMapping("/api/veiculos")

public class VeiculoController {

    private static final Logger logger = LogManager.getLogger(VeiculoController.class);

    @Autowired
    private VeiculoRepositorio veiculoRepositorio;

    @GetMapping
    public List<Veiculo> listarTodos() {
        logger.info("listando todos os veiculos");
        return veiculoRepositorio.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Veiculo> buscarPorId(@PathVariable long id) {
        logger.info("buscando veiculos por ID: {}", id);
        return veiculoRepositorio.findById(id);
    }

    @PostMapping
    public Veiculo cadastrar(@RequestBody Veiculo veiculo) {
        logger.info("veiculo cadastrado com sucesso. {}", veiculo);
        return veiculoRepositorio.save(veiculo);
    }

    @PutMapping("/{id}")
    public Veiculo atualizar(@PathVariable long id, @RequestBody Veiculo veiculoAtualizado) {
        logger.info("atualizando veiculo por ID: {}", id);
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

                    logger.info("Veículo atualizado com sucesso. {}", veiculo);
                    return veiculoRepositorio.save(veiculo);
                })
                .orElseThrow(() -> {
                    logger.warn("Veículo com ID {} não encontrado para atualização.", id);
                    return new RuntimeException("Veículo não encontrado com o ID: " + id);
                });
    }

    @DeleteMapping("/{id}")
    public String deletar(@PathVariable Long id) {
        logger.warn("deletando veiculo por ID: {} ", id);
        veiculoRepositorio.deleteById(id);
        logger.info("veiculo deletado com sucesso. {}", id);
        return "Veículo com ID " + id + " foi deletado com sucesso!";
    }
}
