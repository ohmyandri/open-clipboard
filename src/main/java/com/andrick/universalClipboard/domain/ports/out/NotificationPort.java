package com.andrick.universalClipboard.domain.ports.out;

import com.andrick.universalClipboard.domain.models.clipboard.ClipboardItem;

public interface NotificationPort {
    public void broadcast (ClipboardItem data);
}
