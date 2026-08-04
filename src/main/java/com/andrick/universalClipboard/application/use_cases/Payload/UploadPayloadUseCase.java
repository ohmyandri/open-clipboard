package com.andrick.universalClipboard.application.use_cases.Payload;

import com.andrick.universalClipboard.application.dto.CreateClipboardItem;
import com.andrick.universalClipboard.domain.ports.out.ClipboardRepositoryPort;
import com.andrick.universalClipboard.domain.models.clipboard.ClipboardItem;
import com.andrick.universalClipboard.domain.ports.out.NotificationPort;

import java.util.UUID;

public class UploadPayloadUseCase {
    private final ClipboardRepositoryPort clipboardRepositoryPort;
    private final NotificationPort notificationPort;

    //Constructor-based dependencies injection
    public UploadPayloadUseCase(ClipboardRepositoryPort clipboardRepositoryPort, NotificationPort notificationPort) {
        this.clipboardRepositoryPort = clipboardRepositoryPort;
        this.notificationPort = notificationPort;
    }

    public void uploadPayload(CreateClipboardItem dto){
        ClipboardItem data = new ClipboardItem(
                UUID.randomUUID(),
                dto.userId(),
                dto.originDeviceId(),
                dto.contentType(),
                dto.payload(),
                null
        );

        //Making the data persist
        clipboardRepositoryPort.save(data);
        //Notification to the devices to sync
        notificationPort.broadcast(data);

    }
}
