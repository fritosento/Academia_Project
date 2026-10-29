package com.Academia.project.DTO;

import com.Academia.project.ESTADOS.Treinos_Tipos;
import com.Academia.project.Model.TreinosEntity;
import com.Academia.project.Model.UserEntity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.*;
import org.springframework.beans.BeanUtils;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class ResponseTreino_clienteDTO {
    private String nome;
    private String description;
    @Enumerated(EnumType.STRING)
    private Treinos_Tipos tipo;

    private String usuarioEmail;

    public static ResponseTreino_clienteDTO retorno(TreinosEntity t) {
        return new ResponseTreino_clienteDTO(
                t.getNome(),
                t.getDescription(),
                t.getTipo(),
                t.getUsuario().getEmail()
        );

    }

    public ResponseTreino_clienteDTO(UserEntity userEntity) {
        BeanUtils.copyProperties(userEntity, this);

    }
}
