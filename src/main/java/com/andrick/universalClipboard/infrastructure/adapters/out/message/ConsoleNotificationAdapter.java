package com.andrick.universalClipboard.infrastructure.adapters.out.message;

import com.andrick.universalClipboard.domain.models.clipboard.ClipboardItem;
import com.andrick.universalClipboard.domain.models.device.Device;
import com.andrick.universalClipboard.domain.ports.out.DevicesRepositoryPort;
import com.andrick.universalClipboard.domain.ports.out.NotificationPort;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ConsoleNotificationAdapter implements NotificationPort {
    final private DevicesRepositoryPort devicesRepositoryPort;

    public ConsoleNotificationAdapter(DevicesRepositoryPort devicesRepositoryPort) {
        this.devicesRepositoryPort = devicesRepositoryPort;
    }

    @Override
    public void broadcast(ClipboardItem data) {
        List<Device> devices = devicesRepositoryPort.findDevicesByUserId(data.userId());
        String originDevice = data.originDeviceId();
        System.out.println("Payload Uploaded from: " + originDevice);
        System.out.println();

        devices.stream()
                .filter(device -> !originDevice.equals(device.deviceId()))
                .forEach(targetDevice -> {
                    System.out.println("Sending clipboard to: " + targetDevice.deviceId());
                    System.out.println(data.toString());
                });
    }
}
