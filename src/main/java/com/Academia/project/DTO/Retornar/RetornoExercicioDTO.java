package com.Academia.project.DTO.Retornar;

import com.Academia.project.ESTADOS.Treinos_Tipos;
import com.Academia.project.Model.ExerciciosEntity;
import lombok.Builder;

import java.util.UUID;

public final class RetornoExercicioDTO {
    @Builder
    public record ResponseExercicio(
            UUID id,
            Treinos_Tipos tipo,
            String nome,
            String descricao
    ) {

        public static ResponseExercicio from(ExerciciosEntity e) {
            return new ResponseExercicio(
                    e.getId(),
                    e.getTipo(),
                    e.getNome(),
                    e.getDescription()
            );

        }
    }
}