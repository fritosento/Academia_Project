package com.Academia.project.DTO;

import com.Academia.project.ESTADOS.StausClient;

import com.Academia.project.Model.UserEntity;
import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.*;
import org.springframework.beans.BeanUtils;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class ResponseClienteDTO {
    private String email;
    private String nome;
    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private StausClient status;

    public ResponseClienteDTO(UserEntity userEntity) {
        BeanUtils.copyProperties(userEntity, this);

    }
}
