package com.autofluxer.service;

import com.autofluxer.model.Veiculo;
import com.autofluxer.repository.VeiculoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service

public class VeiculoService {

    @Autowired

    private VeiculoRepositorio veiculoRepositorio;

    public List<Veiculo> listarTodos() {
        return veiculoRepositorio.findAll();
    }

    public Optional<Veiculo> buscarPorId(Long id) {
        return veiculoRepositorio.findById(id);
    }

    public Veiculo salvar(Veiculo veiculo) {
        return veiculoRepositorio.save(veiculo);
    }

    public Veiculo atualizar(Veiculo veiculo) {
        return veiculoRepositorio.save(veiculo);
    }

    public void deletar(Long id) {
        veiculoRepositorio.deleteById(id);
    }
}

