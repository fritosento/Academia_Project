package com.Academia.project.DTO.Criar;

import com.Academia.project.ESTADOS.Treinos_Tipos;
import lombok.Builder;

@Builder
public record CriarTreinoDTO(
        String nome,
        Treinos_Tipos tipos,
        String descricao

)
{}
