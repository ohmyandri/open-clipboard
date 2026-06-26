package com.andrick.universalClipboard.domain.ports.out;

import com.andrick.universalClipboard.domain.models.device.Device;

import java.util.List;

public interface DevicesRepositoryPort {
    List<Device> findDevicesByUserId(String id);

    void addDevice(Device device);
    void removeDevice(String deviceId);
}
