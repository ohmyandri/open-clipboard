package com.andrick.universalClipboard.infrastructure.controllers;

import com.andrick.universalClipboard.application.dto.CreateDevice;
import com.andrick.universalClipboard.application.use_cases.Devices.AddDeviceUseCase;
import com.andrick.universalClipboard.application.use_cases.Users.GetUserDevicesUseCase;
import com.andrick.universalClipboard.application.use_cases.Devices.RemoveDeviceUseCase;
import com.andrick.universalClipboard.domain.models.device.Device;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

@RequestMapping("/api/v1/devices")
public class DeviceController {
    private final AddDeviceUseCase addDeviceUseCase;
    private final RemoveDeviceUseCase removeDeviceUseCase;
    private final GetUserDevicesUseCase getUserDevicesUseCase;

    public DeviceController(AddDeviceUseCase addDeviceUseCase, RemoveDeviceUseCase removeDeviceUseCase, GetUserDevicesUseCase getUserDevicesUseCase) {
        this.addDeviceUseCase = addDeviceUseCase;
        this.removeDeviceUseCase = removeDeviceUseCase;
        this.getUserDevicesUseCase = getUserDevicesUseCase;
    }

    @PostMapping
    void addDevice(
            @RequestBody CreateDevice rawData
            ){
        addDeviceUseCase.execute(rawData);
    }

    @DeleteMapping("/{deviceId}")
    void removeDevice(
            @PathVariable String deviceId
    ){
        removeDeviceUseCase.execute(deviceId);
    }

    @GetMapping
    List<Device> peekUserDevices(
            @RequestHeader("X-User-Id") String userId
    ){
        return getUserDevicesUseCase.execute(userId);
    }
}
