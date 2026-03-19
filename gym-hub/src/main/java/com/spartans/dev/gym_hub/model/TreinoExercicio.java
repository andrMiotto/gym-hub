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
@Table(name = "treinoExercicio")
public class TreinoExercicio {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "treino_id", nullable = false)
    private Treino treino;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "exercicio_id", nullable = false)
    private Exercicio exercicio;

    @Column(nullable = false)
    private int series;

    @Column(nullable = false)
    private int repeticoes;

    @Column(nullable = false)
    private String descanso;

    public TreinoExercicio(Treino treino, Exercicio exercicio, int series, int repeticoes, String descanso) {
        this.treino = treino;
        this.exercicio = exercicio;
        this.series = series;
        this.repeticoes = repeticoes;
        this.descanso = descanso;
    }
}


