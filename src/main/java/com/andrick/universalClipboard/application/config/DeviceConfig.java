package com.andrick.universalClipboard.application.config;

import com.andrick.universalClipboard.application.use_cases.AddDeviceUseCase;
import com.andrick.universalClipboard.application.use_cases.GetUserDevicesUseCase;
import com.andrick.universalClipboard.application.use_cases.RemoveDeviceUseCase;
import com.andrick.universalClipboard.domain.ports.out.DevicesRepositoryPort;
import org.springframework.context.annotation.Bean;

public class DeviceConfig {
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
