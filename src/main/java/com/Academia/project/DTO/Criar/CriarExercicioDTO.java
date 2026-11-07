package com.Academia.project.DTO.Criar;

import com.Academia.project.ESTADOS.Treinos_Tipos;
import lombok.Builder;

@Builder
public record CriarExercicioDTO(
        Treinos_Tipos tipo,
        String nome,
        String descricao
) {}
