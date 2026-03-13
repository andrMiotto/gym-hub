package com.spartans.dev.gym_hub.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "aula")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Aula {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private String descricao;

    @Column(nullable = false)
    private String duracao;

    public Aula(String nome, String descricao, String duracao) {
        this.nome = nome;
        this.descricao = descricao;
        this.duracao = duracao;
    }
}
