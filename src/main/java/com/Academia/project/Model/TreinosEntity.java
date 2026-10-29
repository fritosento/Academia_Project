package com.Academia.project.Model;

import com.Academia.project.ESTADOS.Treinos_Tipos;
import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

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
    private Set<ExerciciosEntity> exercicios = new HashSet<>();

    public void addExercicio(ExerciciosEntity ex) {
        exercicios.add(ex);
        ex.setTreino(this);
    }


}
