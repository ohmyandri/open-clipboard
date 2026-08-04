package com.andrick.universalClipboard.application.dto;

import com.andrick.universalClipboard.domain.models.clipboard.ContentType;

public record CreateClipboardItem(
        String userId,
        String originDeviceId,
        String payload,
        ContentType contentType
) {
}
