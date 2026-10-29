package com.Academia.project.DTO;

import com.Academia.project.ESTADOS.Treinos_Tipos;
import com.Academia.project.Model.ExerciciosEntity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.*;
import org.springframework.beans.BeanUtils;

import java.util.HashSet;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class TreinosDTO {

    private String nome;
    private String descricao;
    @Enumerated(EnumType.STRING)
    private Treinos_Tipos tipo;

    private Set<ExercicioDTO> listaTreinosDTO = new HashSet<>();

    @Builder.Default
    private Set<ExercicioDTO> treinos = new HashSet<>();

    public TreinosDTO(TreinosDTO treinosEntity) {
        BeanUtils.copyProperties(treinosEntity,this);
    }
}
