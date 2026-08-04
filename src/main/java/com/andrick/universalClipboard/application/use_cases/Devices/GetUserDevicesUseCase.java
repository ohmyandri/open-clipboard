package com.andrick.universalClipboard.application.use_cases.Devices;

import com.andrick.universalClipboard.domain.models.device.Device;
import com.andrick.universalClipboard.domain.ports.out.DevicesRepositoryPort;

import java.util.List;

public class GetUserDevicesUseCase {
    final private DevicesRepositoryPort devicesRepositoryPort;

    public GetUserDevicesUseCase(DevicesRepositoryPort devicesRepositoryPort) {
        this.devicesRepositoryPort = devicesRepositoryPort;
    }

    public List<Device> execute(String userId){
        return devicesRepositoryPort.findDevicesByUserId(userId);
    }
}
