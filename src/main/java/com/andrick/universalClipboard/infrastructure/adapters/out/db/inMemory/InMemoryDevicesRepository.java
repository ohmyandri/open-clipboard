package com.andrick.universalClipboard.infrastructure.adapters.out.db.inMemory;

import com.andrick.universalClipboard.domain.models.device.Device;
import com.andrick.universalClipboard.domain.ports.out.DevicesRepositoryPort;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

//@Repository
public class InMemoryDevicesRepository implements DevicesRepositoryPort {
    final private List<Device> repository = new ArrayList<>();

    @Override
    public List<Device> findDevicesByUserId(String id) {
        return repository.stream().filter(
                device -> device.userId().equals(id)
        ).toList();
    }

    @Override
    public void addDevice(Device device) {
        repository.add(device);
    }

    @Override
    public boolean removeDevice(String deviceId) {
        return repository.removeIf(device -> device.deviceId().equals(deviceId));
    }
}
