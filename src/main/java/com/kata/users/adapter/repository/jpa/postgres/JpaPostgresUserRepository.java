package com.kata.users.adapter.repository.jpa.postgres;

import com.kata.users.adapter.repository.jpa.postgres.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;


public interface JpaPostgresUserRepository extends JpaRepository<UserEntity, Long> {

    @Query("SELECT u FROM User u WHERE u.email = ?1")
    Optional<UserEntity> findByEmail(String email);

}
