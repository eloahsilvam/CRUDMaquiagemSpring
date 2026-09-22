package com.maquiagem.cadastro_maquiagem.infraestructure.entitys;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "maquiagem")
@Entity //seria o dto

public class Maquiagem {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "Marca")
    private String marca;

    @Column(name = "cor")
    private String cor;

    @Column(name = "preco")
    private Boolean preco;

    @Column(name = "quantidade")
    private Boolean quantidade;
}
