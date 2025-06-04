package com.autofluxer.service;

import com.autofluxer.model.Movimentacao;
import com.autofluxer.model.Veiculo;
import com.autofluxer.repository.MovimentacaoRepositorio;
import com.autofluxer.repository.VeiculoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class MovimentacaoService {

    @Autowired
    private MovimentacaoRepositorio movimentacaoRepositorio;

    @Autowired
    private VeiculoRepositorio veiculoRepositorio;

    public List<Movimentacao> listarTodas() {
        return movimentacaoRepositorio.findAll();
    }

    public Optional<Movimentacao> buscarPorId(Long id) {
        return movimentacaoRepositorio.findById(id);
    }

    public Movimentacao salvar(Movimentacao movimentacao) {

        movimentacao.setData(LocalDateTime.now());

        Veiculo veiculo = movimentacao.getVeiculo();

        if (movimentacao.getTipo().equalsIgnoreCase("Entrada")) {
            veiculo.setStatus("Disponível");
        } else if (movimentacao.getTipo().equalsIgnoreCase("Saida")) {
            veiculo.setStatus("Indisponível");
        }

        veiculoRepositorio.save(veiculo);

        return movimentacaoRepositorio.save(movimentacao);
    }

    public void deletar(Long id) {
        movimentacaoRepositorio.deleteById(id);
    }
}
