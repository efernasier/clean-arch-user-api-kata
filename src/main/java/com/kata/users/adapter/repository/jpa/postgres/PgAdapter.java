package com.kata.users.adapter.repository.jpa.postgres;

import com.kata.users.adapter.repository.jpa.postgres.entity.UserEntity;
import com.kata.users.domain.User;
import com.kata.users.usecase.port.UserRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.stream.Stream;

@Repository
public class PgAdapter implements UserRepository {

    private final JpaPostgresUserRepository jpaPostgresUserRepository;

    public PgAdapter(JpaPostgresUserRepository jpaPostgresUserRepository) {
        this.jpaPostgresUserRepository = jpaPostgresUserRepository;
    }

    @Override
    public Optional<User> saveUser(User user) {
        UserEntity userEntity = jpaPostgresUserRepository.save(UserEntity.fromDomainUser(user));
        return Optional.of(userEntity).map(UserEntity::fromPgEntity);
    }

    @Override
    public Optional<User> getUserById(Long id) {
        Optional<UserEntity> userEntity = jpaPostgresUserRepository.findById(id);
        return userEntity.map(UserEntity::fromPgEntity);
    }

    @Override
    public Optional<User> findUserByEmail(String email) {
        Optional<UserEntity> userEntity = jpaPostgresUserRepository.findByEmail(email);
        return userEntity.map(UserEntity::fromPgEntity);
    }

    @Override
    public Stream<User> getUsers() {
        return null;
    }

}
