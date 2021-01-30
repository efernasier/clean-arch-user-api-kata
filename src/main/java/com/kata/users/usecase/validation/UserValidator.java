package com.kata.users.usecase.validation;

import com.kata.users.domain.User;
import com.kata.users.usecase.exception.ValidationException;

import java.util.Objects;

public class UserValidator {

    public static void doFieldsValidation(final User user) throws ValidationException {
        if(isEmpty(user.getFullName())) throw new ValidationException("field fullname shouldn't be empty");
        if(isEmpty(user.getAddress())) throw new ValidationException("field address shouldn't be empty");
        if(isEmpty(user.getEmail())) throw new ValidationException("field email shouldn't be empty");
    }

    private static boolean isEmpty(final String str) {
        return Objects.isNull(str) || str.trim().isEmpty();
    }

}
