package com.Academia.project.DTO.Retornar;

import com.Academia.project.ESTADOS.StausClient;
import com.Academia.project.Model.UserEntity;
import lombok.Builder;

import java.util.List;
import java.util.UUID;

public final class RetornoClienteDTO {

    private RetornoClienteDTO(){}
    @Builder
    public record ResponseCliente(
            UUID id,
            String nome,
            String email,
            StausClient status,
            List<ResponseTreino.ResponseTreinoResumo> treinos
    ){

      public static ResponseCliente from(UserEntity u){
            return new ResponseCliente(
                    u.getId(),
                    u.getNome(),
                    u.getEmail(),
                    u.getStatus(),
                    u.getTreinos().stream().map(ResponseTreino.ResponseTreinoResumo::from).toList()
            );
      }
    }
    @Builder
    record ResponseClienteParaRetorno(
            String nome,
            String email
    ){

      public static ResponseClienteParaRetorno from(UserEntity u){
            return new ResponseClienteParaRetorno(
                    u.getNome(),
                    u.getEmail()
            );
      }
}
}


