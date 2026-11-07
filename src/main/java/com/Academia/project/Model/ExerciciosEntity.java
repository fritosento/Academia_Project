package com.Academia.project.Model;

import com.Academia.project.ESTADOS.Treinos_Tipos;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
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

    @Enumerated(EnumType.STRING)
    private Treinos_Tipos tipo;

    private String nome;

    private String description;

    @ManyToOne
    @JoinColumn(name = "treino_id")
    private TreinosEntity treino;

    @PrePersist
    @PreUpdate
    public void UpperCase(){
        if( nome!= null){ nome = nome.trim().toUpperCase();};
    }

}
