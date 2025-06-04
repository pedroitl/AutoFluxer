
package com.autofluxer.model;

import jakarta.persistence.*;
        import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Veiculo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private long idVeiculo;
    private String marca;
    private String modelo;
    private Integer ano;
    private String cor;
    private String placa;
    private String chassi;
    private String renavam;
    private String tipo;
    private String status;
}
