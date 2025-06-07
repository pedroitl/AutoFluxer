package com.autofluxer.service;

import com.autofluxer.model.Veiculo;
import com.autofluxer.repositorio.VeiculoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Service

public class VeiculoService {

    private static final Logger logger = LogManager.getLogger(VeiculoService.class);
    @Autowired

    private VeiculoRepositorio veiculoRepositorio;

    public List<Veiculo> listarTodos() {
        logger.info("listando todos os veiculos");
        return veiculoRepositorio.findAll();
    }

    public Optional<Veiculo> buscarPorId(Long id) {
        logger.info("buscando veiculo por ID: {}", id);
        return veiculoRepositorio.findById(id);
    }

    public Veiculo salvar(Veiculo veiculo) {
        logger.info("veiculo salvo com sucesso. {}", veiculo);
        return veiculoRepositorio.save(veiculo);
    }

    public Veiculo atualizar(Veiculo veiculo) {
        logger.info("veiculo atualizado com sucesso. {}", veiculo);
        return veiculoRepositorio.save(veiculo);
    }

    public void deletar(Long id) {
        logger.warn("deletando veiculo por ID: {}", id);
        veiculoRepositorio.deleteById(id);
        logger.info("veiculo deletado com sucesso. {}", id);

    }
}

