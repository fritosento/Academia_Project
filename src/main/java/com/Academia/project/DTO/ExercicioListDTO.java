package com.Academia.project.DTO;

import com.Academia.project.Model.ExerciciosEntity;
import lombok.*;
import org.springframework.beans.BeanUtils;

import java.util.HashSet;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class ExercicioListDTO {


    Set<ExerciciosEntity> exercicios = new HashSet<>();

    public ExercicioListDTO(ExerciciosEntity treinosEntity) {
        BeanUtils.copyProperties(treinosEntity,this);
    }
}
