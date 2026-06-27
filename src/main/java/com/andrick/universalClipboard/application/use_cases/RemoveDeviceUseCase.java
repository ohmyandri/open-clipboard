package com.andrick.universalClipboard.application.use_cases;

import com.andrick.universalClipboard.domain.exceptions.DomainExceptions;
import com.andrick.universalClipboard.domain.ports.out.DevicesRepositoryPort;

public class RemoveDeviceUseCase {
    final private DevicesRepositoryPort repository;

    public RemoveDeviceUseCase(DevicesRepositoryPort repository) {
        this.repository = repository;
    }

    public void execute(String deviceId){
        boolean response = repository.removeDevice(deviceId);
        if(!response){
            throw new DomainExceptions.DeviceNotFoundException("Device not found");
        }
    }
}
