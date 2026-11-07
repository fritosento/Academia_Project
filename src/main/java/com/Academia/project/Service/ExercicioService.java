package com.Academia.project.Service;

import com.Academia.project.DTO.Criar.CriarExercicioDTO;
import com.Academia.project.DTO.Retornar.RetornoExercicioDTO.ResponseExercicio;
import com.Academia.project.ESTADOS.Treinos_Tipos;
import com.Academia.project.Model.ExerciciosEntity;
import com.Academia.project.Repository.ExercicioRepository;
import com.Academia.project.Repository.TreinosRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class ExercicioService {

    private final ExercicioRepository exercicioRepository;

    public List<ResponseExercicio> receberExercicio( Treinos_Tipos tipo){

        return exercicioRepository.findAllByTipo( tipo)
                .stream()
                .map(ResponseExercicio::from)
                .toList();

    }

    public void criarExercicio(CriarExercicioDTO dto){

        exercicioRepository.save(
                ExerciciosEntity.builder()
                        .tipo(dto.tipo())
                        .nome(dto.nome())
                        .description(dto.descricao())
                        .build()
        );
    }



}
