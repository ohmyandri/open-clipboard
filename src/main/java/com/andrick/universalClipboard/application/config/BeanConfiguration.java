package com.andrick.universalClipboard.application.config;

import com.andrick.universalClipboard.application.use_cases.*;
import com.andrick.universalClipboard.domain.ports.out.ClipboardRepositoryPort;
import com.andrick.universalClipboard.domain.ports.out.DevicesRepositoryPort;
import com.andrick.universalClipboard.domain.ports.out.NotificationPort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfiguration {

    @Bean
    public UploadPayloadUseCase uploadPayloadUseCase(ClipboardRepositoryPort repositoryPort){
        return new UploadPayloadUseCase(repositoryPort);
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
}
