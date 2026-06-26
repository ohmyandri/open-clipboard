package com.andrick.universalClipboard.application.use_cases;

import com.andrick.universalClipboard.application.dto.CreateDevice;
import com.andrick.universalClipboard.domain.models.device.Device;
import com.andrick.universalClipboard.domain.ports.out.DevicesRepositoryPort;
import com.andrick.universalClipboard.infrastructure.adapters.out.db.InMemoryDevicesRepository;

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
