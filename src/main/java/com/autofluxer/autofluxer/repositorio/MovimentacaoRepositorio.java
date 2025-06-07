package com.autofluxer.autofluxer.repositorio;

import com.autofluxer.autofluxer.model.Movimentacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovimentacaoRepositorio extends JpaRepository<Movimentacao, Long> {
}