package com.andrick.universalClipboard.application.use_cases;

import com.andrick.universalClipboard.domain.models.CreateClipboardItem;
import com.andrick.universalClipboard.domain.ports.out.ClipboardRepositoryPort;
import com.andrick.universalClipboard.domain.ports.out.NotificationPort;
import com.andrick.universalClipboard.domain.models.ClipboardItem;

import java.time.LocalDateTime;
import java.util.UUID;

public class UploadPayloadUseCase {
    private final ClipboardRepositoryPort clipboardRepositoryPort;

    //Constructor-based dependencies injection
    public UploadPayloadUseCase(ClipboardRepositoryPort clipboardRepositoryPort) {
        this.clipboardRepositoryPort = clipboardRepositoryPort;
//        this.notificationPort = notificationPort;
    }

    public void uploadPayload(CreateClipboardItem dto){
        ClipboardItem data = new ClipboardItem(
                UUID.randomUUID(),
                dto.userId(),
                dto.contentType(),
                dto.payload(),
                dto.originDeviceId(),
                LocalDateTime.now()
        );

        //Making the data persist
        clipboardRepositoryPort.save(data);
        //Notification to the devices to sync
    }
}
