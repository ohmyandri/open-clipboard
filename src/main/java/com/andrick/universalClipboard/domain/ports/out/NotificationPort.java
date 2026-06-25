package com.andrick.universalClipboard.domain.ports.out;

import com.andrick.universalClipboard.domain.models.ClipboardItem;

public interface NotificationPort {
    public void broadcast (ClipboardItem data);
}
