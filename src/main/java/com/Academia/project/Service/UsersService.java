package com.Academia.project.Service;

import com.Academia.project.DTO.Criar.CriarClienteDTO;
import com.Academia.project.DTO.Retornar.RetornoClienteDTO;
import com.Academia.project.DTO.Retornar.ResponseTreino;
import com.Academia.project.ESTADOS.StausClient;
import com.Academia.project.Exeption.IllegalEX;
import com.Academia.project.Model.UserEntity;
import com.Academia.project.Repository.UsersRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UsersService {

    public final UsersRepository usersRepository;

    public final TreinoService treinoService;

    public RetornoClienteDTO.ResponseCliente getCliente(String email){
        UserEntity u =  usersRepository.findByEmail(email)
                .orElseThrow( () -> new IllegalEX("Ocorreu um erro na busca do cliente"));

        return RetornoClienteDTO.ResponseCliente.from(u);
    }

    public void criarUsuario(CriarClienteDTO dto){

        UserEntity user = usersRepository.findByEmail(dto.email())
                .orElse(null);


        if(user == null) {

            UserEntity newUser = UserEntity
                    .builder()
                    .nome(dto.nome())
                    .email(dto.email())
                    .build();

            if (newUser.getStatus() == null) {
                newUser.setStatus(StausClient.SEM_REGISTRO);
            }
            usersRepository.save(newUser);

        }
        else {
            String email = user.getEmail();
            throw new IllegalEX("O " + email + " ja existe ") ;

        }
    }

    public void ativarStatusCliente(String email){
        UserEntity u = usersRepository.findByEmail(email)
                .orElseThrow(() -> new IllegalEX("Ocorreu um erro na busca do cliente"));

                u.setStatus(StausClient.ATIVO);
                usersRepository.save(u);
    }
    public void BanirStatusCliente(String email){
        UserEntity u = usersRepository.findByEmail(email)
                .orElseThrow(() -> new IllegalEX("Ocorreu um erro na busca do cliente"));

                u.setStatus(StausClient.BANIDO);
                usersRepository.save(u);
    }

    public void cadastrarTreino_Usuario(String credencial, String nomeTreino){

        UserEntity user = usersRepository.findByEmail(credencial)
                .orElseThrow( () -> new IllegalEX("Ocorreu um erro na operação!"));
        if(user.getStatus() == StausClient.SEM_REGISTRO){
            throw new IllegalEX("Usuario não registrado");
        }

        ResponseTreino treino = treinoService.receberTreino(nomeTreino);

        treinoService.adcionarUser_Treino(treino, RetornoClienteDTO.ResponseCliente.from(user));
    }


}