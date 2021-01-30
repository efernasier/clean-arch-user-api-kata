package com.kata.users.app.spring;

import com.kata.users.adapter.controller.UserController;
import com.kata.users.adapter.controller.model.UserDTO;
import com.kata.users.usecase.exception.ResourceNotFoundException;
import com.kata.users.usecase.exception.ValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "api/v1/users")
public class SpringUserController {

    private final UserController userController;

    @Autowired
    public SpringUserController(UserController userController) {
        this.userController = userController;
    }

    @PostMapping
    public UserDTO createUser(@RequestBody UserDTO dto) throws ValidationException {

        return userController.createNewUser(dto);
    }

    @GetMapping(path = "{userId}")
    public UserDTO getUser(@PathVariable Long userId) throws ResourceNotFoundException {
        return userController.findUserById(userId);
    }

}
