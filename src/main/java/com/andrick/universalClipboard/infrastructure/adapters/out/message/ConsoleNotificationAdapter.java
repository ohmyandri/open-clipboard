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

        devices.forEach(device -> {
            if(!originDevice.equals(device.deviceId())){
                System.out.println("The clipboard arrived to: " + device.deviceId());
                System.out.println(device.toString());
                System.out.println();
            }
        });
    }
}
