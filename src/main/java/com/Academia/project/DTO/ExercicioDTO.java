package com.Academia.project.DTO;

import com.Academia.project.ESTADOS.Treinos_Tipos;
import com.Academia.project.Model.ExerciciosEntity;
import lombok.*;
import org.springframework.beans.BeanUtils;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class ExercicioDTO {

    private String Tipo;
    private String referencia;
    private String nome;
    private String descricao;

    public ExercicioDTO(ExerciciosEntity treinosEntity) {
        BeanUtils.copyProperties(treinosEntity,this);
    }
}
