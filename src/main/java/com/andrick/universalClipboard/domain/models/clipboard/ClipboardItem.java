package com.andrick.universalClipboard.domain.models.clipboard;

import java.time.LocalDateTime;
import java.util.UUID;

public record ClipboardItem(
        UUID id,
        String userId,
        ContentType contentType,
        String payload,
        String originDeviceId,
        LocalDateTime createdAt
) {
    public ClipboardItem {
        if (id == null) {
            throw new IllegalArgumentException("Clipboard item ID cannot be null.");
        }
        if (userId == null || userId.isBlank()) {
            throw new IllegalArgumentException("User ID is required and cannot be empty.");
        }
        if (contentType == null) {
            throw new IllegalArgumentException("Content type must be defined.");
        }
        if (payload == null || payload.isBlank()) {
            throw new IllegalArgumentException("Payload content cannot be empty.");
        }
        if (originDeviceId == null || originDeviceId.isBlank()) {
            throw new IllegalArgumentException("Origin device ID is required.");
        }
        if (createdAt == null) {
            throw new IllegalArgumentException("Creation timestamp must be defined.");
        }

        if (contentType == ContentType.TEXT && payload.length() > 100000) {
            throw new IllegalArgumentException("Payload exceeds the maximum allowed limit of 100,000 characters.");
        }
    }
}