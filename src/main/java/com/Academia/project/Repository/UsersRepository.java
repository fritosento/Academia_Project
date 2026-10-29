package com.Academia.project.Repository;

import com.Academia.project.Model.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface UsersRepository  extends JpaRepository<UserEntity, UUID> {
    Optional<UserEntity> findByEmail(String email);
}
