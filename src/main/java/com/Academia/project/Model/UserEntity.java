package com.Academia.project.Model;

import com.Academia.project.ESTADOS.StausClient;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
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
@Table(name = "Usuario",
uniqueConstraints = {
        @UniqueConstraint(columnNames = "email")
})
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "nome")
    private String nome;

    @Column(unique = true, name = "email")
    @Email
    private String email;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private StausClient status;

    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL)
    @Builder.Default
    private Set<TreinosEntity> treinos = new HashSet<>();

    public void addTreino(TreinosEntity treino){
        treinos.add(treino);
        treino.setUsuario(this);
    }
}
