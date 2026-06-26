package com.andrick.universalClipboard.domain.models.device;

public record Device(
        String userId,
        String deviceId,
        String deviceName,
        DeviceType deviceType
) {
}
