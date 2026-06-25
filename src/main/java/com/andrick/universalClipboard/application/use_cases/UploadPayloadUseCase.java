package com.andrick.universalClipboard.application.use_cases;

import com.andrick.universalClipboard.domain.ports.out.ClipboardRepositoryPort;
import com.andrick.universalClipboard.domain.ports.out.NotificationPort;
import com.andrick.universalClipboard.domain.models.ClipboardItem;

public class UploadPayloadUseCase {
    private final ClipboardRepositoryPort clipboardRepositoryPort;
    private final NotificationPort notificationPort;

    public UploadPayloadUseCase(ClipboardRepositoryPort clipboardRepositoryPort, NotificationPort notificationPort) {
        this.clipboardRepositoryPort = clipboardRepositoryPort;
        this.notificationPort = notificationPort;
    }

    public void uploadPayload(ClipboardItem data){
        //Saving to the db (or cloud service)
        clipboardRepositoryPort.save(data);
        //Notification to the devices
        notificationPort.broadcast(data);
    }
}
