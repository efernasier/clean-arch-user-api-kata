package com.kata.users.config;

import com.kata.users.adapter.controller.UserController;
import com.kata.users.adapter.repository.jpa.postgres.JpaPostgresUserRepository;
import com.kata.users.adapter.repository.jpa.postgres.PgAdapter;
import com.kata.users.usecase.FindUser;
import com.kata.users.usecase.SaveUser;
import org.springframework.stereotype.Component;

@Component
public class SpringConfig {

    public UserController userController(JpaPostgresUserRepository repository) {
        final PgAdapter userAdapter =
                new PgAdapter(repository);

        return new UserController(
                new SaveUser(userAdapter),
                new FindUser(userAdapter)
        );
    }

}
