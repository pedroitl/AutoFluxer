package com.autofluxer.repository;

import com.autofluxer.model.Movimentacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovimentacaoRepositorio extends JpaRepository<Movimentacao, Long> {
}