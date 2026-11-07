package com.Academia.project.Service;

import com.Academia.project.DTO.Criar.CriarTreinoDTO;
import com.Academia.project.DTO.Retornar.ResponseExercicioComTreino;
import com.Academia.project.DTO.Retornar.ResponseTreino;
import com.Academia.project.DTO.Retornar.RetornoClienteDTO;
import com.Academia.project.DTO.Retornar.RetornoExercicioDTO.ResponseExercicio;
import com.Academia.project.ESTADOS.Treinos_Tipos;
import com.Academia.project.Exeption.IllegalEX;
import com.Academia.project.Model.ExerciciosEntity;
import com.Academia.project.Model.TreinosEntity;
import com.Academia.project.Model.UserEntity;
import com.Academia.project.Repository.ExercicioRepository;
import com.Academia.project.Repository.TreinosRepository;
import com.Academia.project.Repository.UsersRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TreinoService {

    private final UsersRepository usersRepository;

    private final TreinosRepository treinosRepository;
    private final ExercicioRepository exercicioRepository;


    public ResponseTreino receberTreino(
             String nome) {
        TreinosEntity t = treinosRepository.findByNome(nome)
                .orElseThrow(() -> new IllegalEX("Ocorreu um erro na busca!")
                );

        return ResponseTreino.from(t);

    }

    public List<ResponseTreino> receberTreinoUser(Treinos_Tipos Tipo, String email) {

        System.out.println(treinosRepository.findByTipoAndUsuarioEmail(Tipo, email));
        List<ResponseTreino> treinos = treinosRepository.findByTipoAndUsuarioEmail(Tipo, email)
                .stream()
                .map(ResponseTreino::from)
                .toList();

        if (treinos.isEmpty()) {
            throw new IllegalEX("Ocorreu um erro na busca!");
        }
        return treinos;
    }


    public void criarTreino(CriarTreinoDTO dto) {

        treinosRepository.save(
                TreinosEntity.builder()
                        .nome(dto.nome().toUpperCase())
                        .description(dto.descricao().toUpperCase())
                        .tipo(dto.tipos())
                        .build()
        );

    }

    public void adcionarUser_Treino(ResponseTreino treinoDTO, RetornoClienteDTO.ResponseCliente userDTO) {

        UserEntity user = usersRepository.findByEmail(userDTO.email())
                .orElseThrow(() -> new IllegalEX("Ocorreu um erro na operacao"));
        TreinosEntity treino = treinosRepository.findByNome(treinoDTO.nome())
                .orElseThrow(() -> new IllegalEX("Ocorreu um erro na operacao"));

        treino.setUsuario(user);
        treinosRepository.save(treino);
    }

    public void adcionarExercicioEmTreino(String nomeTreino, String nomeExercicio) {

        TreinosEntity treino = treinosRepository.findByNome(nomeTreino)
                .orElseThrow(() -> new IllegalEX("Ocorreu um erro na operacao"));
        ExerciciosEntity ex = exercicioRepository.findByNome(nomeExercicio)
                .orElseThrow(() -> new IllegalEX("Ocorreu um erro na operacao"));

        ex.setTreino(treino);
        treino.addExercicio(ex);

        exercicioRepository.save(ex);

    }
}
