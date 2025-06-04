package com.autofluxer.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor


public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long idCliente;

    private String nome;

    private String cpfCnpj;

    private String endereco;

    private String telefone;

    private String email;

}
