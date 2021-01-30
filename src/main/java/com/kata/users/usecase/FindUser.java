package com.kata.users.usecase;

import com.kata.users.domain.User;
import com.kata.users.usecase.exception.ResourceNotFoundException;
import com.kata.users.usecase.port.UserRepository;

public class FindUser {

    private final UserRepository repository;

    public FindUser(UserRepository repository) {
        this.repository = repository;
    }

    public User byId(final Long id) throws ResourceNotFoundException {
        return repository.getUserById(id).orElseThrow(
                () -> new ResourceNotFoundException("user with id " + id.toString() + " does not exist.")
        );
    }
}
