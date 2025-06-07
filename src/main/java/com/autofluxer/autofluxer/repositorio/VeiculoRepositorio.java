package com.autofluxer.autofluxer.repositorio;

import com.autofluxer.autofluxer.model.Veiculo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface VeiculoRepositorio extends JpaRepository<Veiculo, Long>{
}