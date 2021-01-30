package com.kata.users.usecase;

import com.kata.users.domain.User;
import com.kata.users.usecase.exception.ValidationException;
import com.kata.users.usecase.port.UserRepository;
import com.kata.users.usecase.validation.UserValidator;

public class SaveUser {

    private final UserRepository repository;

    public SaveUser(UserRepository repository) {
        this.repository = repository;
    }

    public User createUser(final User user) throws ValidationException {
        UserValidator.doFieldsValidation(user);
        checkEmail(user.getEmail());
        return repository.saveUser(user).get();
    }

    private void checkEmail(final String email) throws ValidationException {
        boolean userExist = repository.findUserByEmail(email).isPresent();
        if(userExist) {
            throw new ValidationException("user with email " + email +" already exist");
        }
    }
}
