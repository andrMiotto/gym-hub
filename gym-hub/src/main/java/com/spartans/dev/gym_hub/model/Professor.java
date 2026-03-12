package com.spartans.dev.gym_hub.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "professor")
public class Professor {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private String cref;

    @Column(nullable = false)
    private String especialidade;

    @Column(nullable = false)
    private String sobre;

    @Column(nullable = false)
    private Double avaliacao;

    @Column(nullable = false)
    private String cpf;


    public Professor(String nome, String cref, String especialidade, String sobre, Double avaliacao, String cpf) {
        this.nome = nome;
        this.cref = cref;
        this.especialidade = especialidade;
        this.sobre = sobre;
        this.avaliacao = avaliacao;
        this.cpf = cpf;
    }
}
