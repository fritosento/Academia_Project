package com.Academia.project.DTO;

import com.Academia.project.ESTADOS.Treinos_Tipos;
import com.Academia.project.Model.ExerciciosEntity;
import com.Academia.project.Model.UserEntity;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.beans.BeanUtils;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class TreinosDTO {

    private UserEntity usuario;

    private Set<ExerciciosEntity> exercicios = new HashSet<>();

    private String nome;

    private String descricao;

    @Enumerated(EnumType.STRING)
    private Treinos_Tipos tipo;



    public TreinosDTO(TreinosDTO treinosEntity) {
        BeanUtils.copyProperties(treinosEntity,this);
    }
}
