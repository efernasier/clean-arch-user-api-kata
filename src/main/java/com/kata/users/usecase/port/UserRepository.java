package com.kata.users.usecase.port;

import com.kata.users.domain.User;

import java.util.Optional;
import java.util.stream.Stream;

public interface UserRepository {
    Optional<User> saveUser(final User user);
    Optional<User> getUserById(final Long id);
    Optional<User> findUserByEmail(final String email);
    Stream<User> getUsers();
}
