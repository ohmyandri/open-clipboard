package com.andrick.universalClipboard.application.dto;

import com.andrick.universalClipboard.domain.models.device.DeviceType;

public record CreateDevice(
        String userId,
        String deviceId,
        String deviceName,
        DeviceType deviceType
) {
}
