package com.Academia.project.Service;

import com.Academia.project.DTO.ExercicioDTO;
import com.Academia.project.DTO.TreinosDTO;
import com.Academia.project.Model.ExerciciosEntity;
import com.Academia.project.Model.TreinosEntity;
import com.Academia.project.Repository.ExercicioRepository;
import com.Academia.project.Repository.TreinosRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class ExercicioService {

    private final ExercicioRepository exercicioRepository;
    private final TreinoService treinoService;
    private final TreinosRepository trienosRepository;

    private ExerciciosEntity receberExercicio(String nome, String tipo){

        return exercicioRepository.findByNomeAndTipo(nome, tipo)
                .orElseThrow(() -> new IllegalArgumentException("Ocorreu um erro na operação"));

    }

    private void criarExercicio(ExercicioDTO dto){


        exercicioRepository.save(
                ExerciciosEntity.builder()
                        .tipo(dto.getTipo())
                        .nome(dto.getNome())
                        .description(dto.getDescricao())
                        .build()
        );
    }
    private void cadastrarEx_Treino(TreinosDTO dtoT, ExercicioDTO dtoE){

        TreinosEntity treino = treinoService.receberTreino(dtoT.getNome());
        ExerciciosEntity ex = receberExercicio(dtoE.getNome(), dtoE.getTipo());

        treino.addExercicio(ex);
    }

}
