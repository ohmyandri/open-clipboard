package com.andrick.universalClipboard.application.config;

import com.andrick.universalClipboard.application.use_cases.AddUserUseCase;
import com.andrick.universalClipboard.application.use_cases.RemoveUserUseCase;
import com.andrick.universalClipboard.domain.ports.out.UserRepositoryPort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UserConfig {
    @Bean
    public AddUserUseCase addUserUseCase(UserRepositoryPort userRepositoryPort){
        return new AddUserUseCase(userRepositoryPort);
    }

    @Bean
    public RemoveUserUseCase removeUserUseCase(UserRepositoryPort userRepositoryPort){
        return new RemoveUserUseCase(userRepositoryPort);
    }
}
