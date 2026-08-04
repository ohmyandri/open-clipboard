package com.andrick.universalClipboard.infrastructure.controllers;

import com.andrick.universalClipboard.application.dto.CreateUser;
import com.andrick.universalClipboard.application.use_cases.Users.AddUserUseCase;
import com.andrick.universalClipboard.application.use_cases.Users.RemoveUserUseCase;
import org.springframework.web.bind.annotation.*;

@RestController

@RequestMapping("/api/v1/users")
public class UserController {
    private final AddUserUseCase addUserUseCase;
    private final RemoveUserUseCase removeUserUseCase;

    public UserController(AddUserUseCase addUserUseCase, RemoveUserUseCase removeUserUseCase) {
        this.addUserUseCase = addUserUseCase;
        this.removeUserUseCase = removeUserUseCase;
    }

    @PostMapping
    void addUser(
            @RequestBody CreateUser createUser
            ){
        addUserUseCase.execute(createUser);
    }

    @DeleteMapping("/{userId}")
    void deleteUser(
            @PathVariable String userId
    ){
        removeUserUseCase.execute(userId);
    }
}
