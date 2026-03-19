package com.spartans.dev.gym_hub.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "ficha")
public class Ficha {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private String objetivo;

    @Column(nullable = false)
    private long usuario_id;

    public Ficha(String nome, String objetivo, long usuario_id) {
        this.nome = nome;
        this.objetivo = objetivo;
        this.usuario_id = usuario_id;
    }
}

