package com.andrick.universalClipboard.application.use_cases.Users;

import com.andrick.universalClipboard.application.dto.CreateUser;
import com.andrick.universalClipboard.domain.models.user.User;
import com.andrick.universalClipboard.domain.ports.out.UserRepositoryPort;

public class AddUserUseCase {
    final private UserRepositoryPort userRepositoryPort;

    public AddUserUseCase(UserRepositoryPort userRepositoryPort) {
        this.userRepositoryPort = userRepositoryPort;
    }

    public void execute (CreateUser createUser){
        User user = new User(
                createUser.userId(),
                createUser.email(),
                null
        );
        userRepositoryPort.save(user);
    }
}
