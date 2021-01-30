package com.kata.users.usecase;

import com.kata.users.domain.User;
import com.kata.users.usecase.exception.ValidationException;
import com.kata.users.usecase.port.UserRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class SaveUserEntityTest {

    @Test
    void ShouldValidateUserWithFullNameEmpty() {
        UserRepository mockRepository = Mockito.mock(UserRepository.class);
        SaveUser useCase = new SaveUser(mockRepository);

        User emptyUser = new User.Builder()
                .withAddress("Some address")
                .withEmail("foo@foo.com")
                .build();

        ValidationException thrown = assertThrows(
                ValidationException.class,
                () -> useCase.createUser(emptyUser)
        );

        String expectedMessage = "field fullname shouldn't be empty";

        assertTrue(thrown.getMessage().contains(expectedMessage),
                "the expected message does not match");
    }

    @Test
    void ShouldValidateUserWithAddressEmpty() {
        UserRepository mockRepository = Mockito.mock(UserRepository.class);
        SaveUser useCase = new SaveUser(mockRepository);

        User emptyUser = new User.Builder()
                .withFullName("Foo")
                .withEmail("foo@foo.com")
                .build();

        ValidationException thrown = assertThrows(
                ValidationException.class,
                () -> useCase.createUser(emptyUser)
        );

        String expectedMessage = "field address shouldn't be empty";

        assertTrue(thrown.getMessage().contains(expectedMessage),
                "the expected message does not match");
    }

    @Test
    void ShouldValidateUserWithEmailEmpty() {
        UserRepository mockRepository = Mockito.mock(UserRepository.class);
        SaveUser useCase = new SaveUser(mockRepository);

        User emptyUser = new User.Builder()
                .withFullName("Foo")
                .withAddress("Some address")
                .build();

        ValidationException thrown = assertThrows(
                ValidationException.class,
                () -> useCase.createUser(emptyUser)
        );

        String expectedMessage = "field email shouldn't be empty";

        assertTrue(thrown.getMessage().contains(expectedMessage),
                "the expected message does not match");
    }

    @Test
    void ShouldValidateAnExistentEmail(){
        UserRepository mockRepository = Mockito.mock(UserRepository.class);

        Mockito.when(mockRepository.findUserByEmail(Mockito.anyString()))
                .thenReturn(Optional.of(
                        new User.Builder()
                                .withFullName("Foo")
                                .withAddress("Some address")
                                .withEmail("foo@foo.com")
                                .build()
                ));

        SaveUser useCase = new SaveUser(mockRepository);

        User emptyUser = new User.Builder()
                .withFullName("Foo")
                .withAddress("Some address")
                .withEmail("foo@foo.com")
                .build();

        ValidationException thrown = assertThrows(
                ValidationException.class,
                () -> useCase.createUser(emptyUser)
        );

        String expectedMessage = "user with email foo@foo.com already exist";

        assertTrue(thrown.getMessage().contains(expectedMessage),
                "the expected message does not match was: "+ thrown.getMessage());
    }
}