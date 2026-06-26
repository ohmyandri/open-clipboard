package com.andrick.universalClipboard.application.use_cases;

import com.andrick.universalClipboard.domain.ports.out.DevicesRepositoryPort;

public class RemoveDeviceUseCase {
    final private DevicesRepositoryPort repository;

    public RemoveDeviceUseCase(DevicesRepositoryPort repository) {
        this.repository = repository;
    }

    public void execute(String deviceId){
        repository.removeDevice(deviceId);
    }
}
