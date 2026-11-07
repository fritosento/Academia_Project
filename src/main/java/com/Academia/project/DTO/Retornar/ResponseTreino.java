package com.Academia.project.DTO.Retornar;

import com.Academia.project.ESTADOS.Treinos_Tipos;
import com.Academia.project.Model.TreinosEntity;
import com.Academia.project.DTO.Retornar.RetornoExercicioDTO.ResponseExercicio;

import lombok.Builder;

import java.util.List;
import java.util.UUID;

@Builder
public record ResponseTreino (
        UUID id,
        String nome,
        String description,
        Treinos_Tipos tipo,
        String usuarioNome,
        List<ResponseExercicio> exercicio
) {

    public static ResponseTreino from(TreinosEntity t) {
        return new ResponseTreino(
                t.getId(),
                t.getNome(),
                t.getDescription(),
                t.getTipo(),
                t.getUsuario() != null ? t.getUsuario().getNome() : null,
                t.getExercicios().stream().map(ResponseExercicio::from).toList()
        );

    }
    public record ResponseTreinoResumo(UUID id, String nome, String descricao, Treinos_Tipos tipo) {
        public static ResponseTreinoResumo from(TreinosEntity t) {
            return new ResponseTreinoResumo(t.getId(), t.getNome(), t.getDescription(), t.getTipo());
        }
    }
}
