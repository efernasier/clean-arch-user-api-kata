package com.kata.users.usecase;

import com.kata.users.usecase.exception.ResourceNotFoundException;
import com.kata.users.usecase.port.UserRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class FindUserEntityTest {

    @Test
    void ShouldReturnUserNotFound() {
        UserRepository userRepository = Mockito.mock(UserRepository.class);
        Mockito.when(userRepository.getUserById(Mockito.anyLong()))
                .thenReturn(Optional.empty());

        FindUser useCase = new FindUser(userRepository);

        ResourceNotFoundException thrown = assertThrows(
                ResourceNotFoundException.class,
                () -> useCase.byId(1L)
        );

        String expectedMessage = "user with id 1 does not exist.";
        assertTrue(thrown.getMessage().contains(expectedMessage),
                "Messsage not match was: " + thrown.getMessage());
    }
}