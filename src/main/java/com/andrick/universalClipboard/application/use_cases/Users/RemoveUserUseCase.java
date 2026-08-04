package com.andrick.universalClipboard.application.use_cases.Users;

import com.andrick.universalClipboard.domain.ports.out.UserRepositoryPort;

public class RemoveUserUseCase {
    private final UserRepositoryPort userRepositoryPort;

    public RemoveUserUseCase(UserRepositoryPort userRepositoryPort) {
        this.userRepositoryPort = userRepositoryPort;
    }

    public void execute(String userId){
        userRepositoryPort.remove(userId);
    }
}
