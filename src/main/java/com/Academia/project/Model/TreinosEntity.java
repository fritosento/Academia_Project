package com.Academia.project.Model;

import com.Academia.project.DTO.Retornar.ResponseExercicioComTreino;
import com.Academia.project.ESTADOS.Treinos_Tipos;
import jakarta.persistence.*;
import lombok.*;

import java.util.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "Treinos",
uniqueConstraints = {
        @UniqueConstraint(columnNames = "nome")
})
public class TreinosEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "nome")
    private String nome;

    private String description;

    @Enumerated(EnumType.STRING)
    private Treinos_Tipos tipo;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private UserEntity usuario;

    @OneToMany(mappedBy = "treino", cascade = CascadeType.ALL)
    @Builder.Default
    private List<ExerciciosEntity> exercicios = new ArrayList<>();

    public void addExercicio(ExerciciosEntity exercicio) {
        exercicios.add(exercicio);
    }

}
