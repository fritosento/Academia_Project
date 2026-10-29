package com.Academia.project.Repository;

import com.Academia.project.ESTADOS.Treinos_Tipos;
import com.Academia.project.Model.ExerciciosEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface ExercicioRepository extends JpaRepository<ExerciciosEntity, UUID> {

    Optional<ExerciciosEntity> findByNome(String nome);
    Optional<ExerciciosEntity> findByTipo(String tipo);

    Optional<ExerciciosEntity> findByTipoOrNome(String tipo, String nome);

    Optional<ExerciciosEntity> findByNomeAndTipo(String nome, String tipo);
}
