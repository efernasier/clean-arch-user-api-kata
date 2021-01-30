package com.kata.users.adapter.controller;

import com.kata.users.adapter.controller.model.UserDTO;
import com.kata.users.domain.User;
import com.kata.users.usecase.SaveUser;
import com.kata.users.usecase.FindUser;
import com.kata.users.usecase.exception.ResourceNotFoundException;
import com.kata.users.usecase.exception.ValidationException;

public class UserController {

    private final SaveUser saveUser;
    private final FindUser findUser;

    public UserController(SaveUser saveUser, FindUser findUser) {
        this.saveUser = saveUser;
        this.findUser = findUser;
    }

    public UserDTO createNewUser(final UserDTO dto) throws ValidationException {
        User user = dto.toUser();
        return UserDTO.toUserDTO(saveUser.createUser(user));
    }

    public UserDTO findUserById(final Long userId) throws ResourceNotFoundException {
        return UserDTO.toUserDTO(findUser.byId(userId));
    }




}
