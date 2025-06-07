package com.autofluxer.service;

import com.autofluxer.model.Movimentacao;
import com.autofluxer.model.Veiculo;
import com.autofluxer.repositorio.MovimentacaoRepositorio;
import com.autofluxer.repositorio.VeiculoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Service
public class MovimentacaoService {

    private static final Logger logger = LogManager.getLogger(MovimentacaoService.class);

    @Autowired
    private MovimentacaoRepositorio movimentacaoRepositorio;

    @Autowired
    private VeiculoRepositorio veiculoRepositorio;

    public List<Movimentacao> listarTodas() {
        logger.info("listando todas as movimentacoes");
        return movimentacaoRepositorio.findAll();
    }

    public Optional<Movimentacao> buscarPorId(Long id) {
        logger.info("buscando movimentacao por ID: {}", id);
        return movimentacaoRepositorio.findById(id);
    }

    public Movimentacao salvar(Movimentacao movimentacao) {
        logger.info("salvando nova movimentacao");
        movimentacao.setData(LocalDateTime.now());

        Veiculo veiculo = movimentacao.getVeiculo();

        if (movimentacao.getTipo().equalsIgnoreCase("Entrada")) {
            logger.info("movimentacao disponivel.  {}", movimentacao);
            veiculo.setStatus("Disponível");
        } else if (movimentacao.getTipo().equalsIgnoreCase("Saida")) {
            logger.warn("movimentacao indisponivel. {}", movimentacao);
            veiculo.setStatus("Indisponível");
        }

        veiculoRepositorio.save(veiculo);
        logger.info("movimentacao salva com sucesso. {}", movimentacao);

        return movimentacaoRepositorio.save(movimentacao);
    }

    public void deletar(Long id) {
        logger.warn("delentado movimentacao por ID: {}", id);
        movimentacaoRepositorio.deleteById(id);
        logger.info("movimentacao deletada, ID: {}",id);
    }
}
