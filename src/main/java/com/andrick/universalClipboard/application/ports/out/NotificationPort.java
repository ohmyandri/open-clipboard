package com.andrick.universalClipboard.application.ports.out;

import com.andrick.universalClipboard.domain.models.ClipboardItem;

public interface NotificationPort {
    public void broadcast (ClipboardItem data);
}
