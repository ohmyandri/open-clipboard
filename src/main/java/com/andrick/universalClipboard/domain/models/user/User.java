package com.andrick.universalClipboard.domain.models.user;

import java.time.LocalDateTime;

public record User(
        String userId,
        String email,
        LocalDateTime createdAt
) {
}
