package com.Academia.project.Model;

import com.Academia.project.ESTADOS.Treinos_Tipos;
import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "Exercicios")
public class ExerciciosEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String tipo;

    private String nome;

    private String description;

    @ManyToOne
    @JoinColumn(name = "treino_id")
    private TreinosEntity treino;
}
