package com.Academia.project.DTO.Retornar;

import com.Academia.project.ESTADOS.Treinos_Tipos;
import com.Academia.project.Model.ExerciciosEntity;
import lombok.Builder;

import java.util.UUID;

@Builder
public record ResponseExercicioComTreino(
        String nome,
        String descricao,
        Treinos_Tipos tipos,
        UUID treinosId
) {
    public static ResponseExercicioComTreino from(ExerciciosEntity e){
        return new ResponseExercicioComTreino(
                e.getNome(),
                e.getDescription(),
                e.getTipo(),
                e.getTreino().getId()
        );
    }
}
