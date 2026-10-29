package com.Academia.project.Service;

import com.Academia.project.DTO.ExercicioListDTO;
import com.Academia.project.DTO.TreinosDTO;
import com.Academia.project.ESTADOS.Treinos_Tipos;
import com.Academia.project.DTO.ResponseTreino_clienteDTO;
import com.Academia.project.Model.ExerciciosEntity;
import com.Academia.project.Model.TreinosEntity;
import com.Academia.project.Model.UserEntity;
import com.Academia.project.Repository.ExercicioRepository;
import com.Academia.project.Repository.TreinosRepository;
import com.Academia.project.Repository.UsersRepository;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TreinoService {

    private final UsersRepository usersRepository;

    private final TreinosRepository treinosRepository;
    private final ExercicioRepository exercicioRepository;


    public TreinosEntity receberTreino(
             String nome) {
        return treinosRepository.findByNome(nome)
                .orElseThrow(() -> new IllegalArgumentException("Ocorreu um erro na busca!")
                );
    }

    public List<ResponseTreino_clienteDTO> receberTreinoUser(Treinos_Tipos Tipo, String email) {

        System.out.println(treinosRepository.findByTipoAndUsuarioEmail(Tipo, email));
        List<ResponseTreino_clienteDTO> treinos = treinosRepository.findByTipoAndUsuarioEmail(Tipo, email)
                .stream()
                .map(ResponseTreino_clienteDTO::retorno)
                .toList();
        if (treinos.isEmpty()) {
            throw new IllegalArgumentException("Ocorreu um erro na busca!");
        }
        return treinos;
    }


    public void criarTreino(TreinosDTO dto) {

        treinosRepository.save(
                TreinosEntity.builder()
                        .nome(dto.getNome().toUpperCase())
                        .description(dto.getDescricao().toUpperCase())
                        .tipo(dto.getTipo())
                        .build()
        );

    }

    public void criarTreinoComExercicio(TreinosDTO treinosDTO, ExercicioListDTO exListDTO) {

        criarTreino(treinosDTO);

        TreinosEntity treino = treinosRepository.findByNome(treinosDTO.getNome())
                .orElseThrow(() -> new IllegalArgumentException("Ocorreu um erro na busca!"));

        for (ExerciciosEntity exercicio : exListDTO.getExercicios()) {
            ExerciciosEntity ex = exercicioRepository.findByNomeAndTipo(exercicio.getNome(), exercicio.getTipo())
                    .orElseThrow(() -> new IllegalArgumentException("Ocorreu um erro na busca!"));
            treino.addExercicio(ex);
        }
    }
    public void adcionarUser_Treino(TreinosEntity treino, UserEntity user) {


        treino.setUsuario(user);
        treinosRepository.save(treino);
    }
}
