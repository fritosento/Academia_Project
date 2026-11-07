package com.Academia.project.DTO.Criar;

import com.Academia.project.ESTADOS.StausClient;

import com.Academia.project.Model.UserEntity;
import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.*;
import org.springframework.beans.BeanUtils;


@Builder
public record CriarClienteDTO(
        String email,
        String nome){}

