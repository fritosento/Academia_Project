package com.Academia.project.Repository;

import com.Academia.project.ESTADOS.Treinos_Tipos;
import com.Academia.project.Model.ExerciciosEntity;
import com.Academia.project.Model.TreinosEntity;
import com.Academia.project.Model.UserEntity;
import org.apache.catalina.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;

public interface TreinosRepository extends JpaRepository<TreinosEntity, UUID> {

    Optional<TreinosEntity> findByNome(String nome);
    Optional<TreinosEntity> findByTipo(Treinos_Tipos tipo);

    List<TreinosEntity> findByTipoAndUsuarioEmail(Treinos_Tipos tipo, String email);

    Optional<TreinosEntity> findByTipoOrNome(Treinos_Tipos tipo, String nome);

}
