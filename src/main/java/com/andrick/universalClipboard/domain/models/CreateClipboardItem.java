package com.andrick.universalClipboard.domain.models;

import java.time.LocalDateTime;

public record CreateClipboardItem(
        String userId,
        ContentType contentType,
        String payload,
        String originDeviceId
) {
}
