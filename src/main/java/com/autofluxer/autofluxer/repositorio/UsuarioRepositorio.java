package com.autofluxer.autofluxer.repositorio;

import com.autofluxer.autofluxer.model.Usuario;
import com.autofluxer.autofluxer.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository

public interface UsuarioRepositorio extends JpaRepository<Usuario, Long> {
    Optional<Usuario> findByEmail(String email);
}
