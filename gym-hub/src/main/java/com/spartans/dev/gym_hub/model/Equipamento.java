package com.spartans.dev.gym_hub.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "equipmaneto")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Equipamento {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private String descricao;

    @Column(nullable = false)
    private String anatomia;

    public Equipamento(String nome, String descricao, String anatomia) {
        this.nome = nome;
        this.descricao = descricao;
        this.anatomia = anatomia;
    }
}
