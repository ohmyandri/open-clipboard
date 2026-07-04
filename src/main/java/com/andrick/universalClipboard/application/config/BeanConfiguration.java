package com.andrick.universalClipboard.application.config;

import com.andrick.universalClipboard.application.use_cases.*;
import com.andrick.universalClipboard.domain.models.clipboard.ClipboardItem;
import com.andrick.universalClipboard.domain.ports.out.ClipboardRepositoryPort;
import com.andrick.universalClipboard.domain.ports.out.DevicesRepositoryPort;
import com.andrick.universalClipboard.domain.ports.out.NotificationPort;
import com.andrick.universalClipboard.domain.ports.out.UserRepositoryPort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfiguration {
    @Bean
    public UploadPayloadUseCase uploadPayloadUseCase(ClipboardRepositoryPort repositoryPort, NotificationPort notificationPort){
        return new UploadPayloadUseCase(repositoryPort, notificationPort);
    }

    @Bean
    public GetPayloadUseCase getPayloadUseCase(ClipboardRepositoryPort repositoryPort) {
        return new GetPayloadUseCase(repositoryPort);
    }

    @Bean
    public AddDeviceUseCase addDeviceUseCase(DevicesRepositoryPort devicesRepositoryPort){
        return new AddDeviceUseCase(devicesRepositoryPort);
    }

    @Bean
    public RemoveDeviceUseCase removeDeviceUseCase(DevicesRepositoryPort devicesRepositoryPort){
        return new RemoveDeviceUseCase(devicesRepositoryPort);
    }

    @Bean
    public GetUserDevicesUseCase getUserDevicesUseCase(DevicesRepositoryPort devicesRepositoryPort){
        return new GetUserDevicesUseCase(devicesRepositoryPort);
    }

    @Bean
    public AddUserUseCase addUserUseCase(UserRepositoryPort userRepositoryPort){
        return new AddUserUseCase(userRepositoryPort);
    }

    @Bean
    public RemoveUserUseCase removeUserUseCase(UserRepositoryPort userRepositoryPort){
        return new RemoveUserUseCase(userRepositoryPort);
    }
}
