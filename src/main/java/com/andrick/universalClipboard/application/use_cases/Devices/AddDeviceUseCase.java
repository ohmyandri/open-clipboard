package com.andrick.universalClipboard.application.use_cases.Devices;

import com.andrick.universalClipboard.application.dto.CreateDevice;
import com.andrick.universalClipboard.domain.models.device.Device;
import com.andrick.universalClipboard.domain.ports.out.DevicesRepositoryPort;

public class AddDeviceUseCase {
    final private DevicesRepositoryPort repository;

    public AddDeviceUseCase(DevicesRepositoryPort repository) {
        this.repository = repository;
    }

    public void execute(CreateDevice createDevice){
        Device device = new Device(createDevice.userId(), createDevice.deviceId(), createDevice.deviceName(), createDevice.deviceType());
        repository.addDevice(device);
    }
}
