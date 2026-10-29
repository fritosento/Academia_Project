package com.Academia.project.Service;

import com.Academia.project.DTO.CriarClienteDTO;
import com.Academia.project.DTO.TreinosDTO;
import com.Academia.project.ESTADOS.StausClient;
import com.Academia.project.Model.TreinosEntity;
import com.Academia.project.Model.UserEntity;
import com.Academia.project.Repository.UsersRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UsersService {

    public final UsersRepository usersRepository;

    public final TreinoService treinoService;

    public UserEntity getCliente(String email){

        return usersRepository.findByEmail(email)
                .orElseThrow( () -> new IllegalArgumentException("Ocorreu um erro na busca do cliente"));

    }

    public void save(CriarClienteDTO dto){

        UserEntity user = UserEntity
                .builder()
                .nome(dto.getNome())
                .email(dto.getEmail())
                .status(dto.getStatus())
                .build();
        usersRepository.save(user);
    }

    public void cadastrarTreino_Usuario(String credencial, String nomeTreino){

        UserEntity user = usersRepository.findByEmail(credencial)
                .orElseThrow( () -> new IllegalArgumentException("Ocorreu um erro na operação!"));
        if(user.getStatus() == StausClient.SEM_REGISTRO){
            throw new IllegalArgumentException("Usuario não registrado");
        }

        TreinosEntity treino = treinoService.receberTreino(nomeTreino);

        treinoService.adcionarUser_Treino(treino, user);
    }


}