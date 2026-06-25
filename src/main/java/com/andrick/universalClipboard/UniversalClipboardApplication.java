package com.andrick.universalClipboard;

import com.andrick.universalClipboard.domain.ports.out.ClipboardRepositoryPort;
import com.andrick.universalClipboard.domain.ports.out.NotificationPort;
import com.andrick.universalClipboard.domain.models.ClipboardItem;
import com.andrick.universalClipboard.domain.models.ContentType;
import com.andrick.universalClipboard.application.use_cases.GetPayloadUseCase;
import com.andrick.universalClipboard.application.use_cases.UploadPayloadUseCase;
import com.andrick.universalClipboard.infrastructure.adapters.out.persistence.InMemoryRepository;

import java.time.LocalDateTime;
import java.util.UUID;

public class UniversalClipboardApplication {

    public static void main(String[] args) {
        ClipboardRepositoryPort clipboardRepositoryPort = new InMemoryRepository();

        NotificationPort notificationPort = message -> System.out.println("Notificación enviada: " + message);

        UploadPayloadUseCase uploadPayloadUseCase = new UploadPayloadUseCase(clipboardRepositoryPort, notificationPort);

        uploadPayloadUseCase.uploadPayload(
                new ClipboardItem(
                        UUID.randomUUID(),
                        "andrick1",
                        ContentType.TEXT,
                        "Hello, test1",
                        "Macbook m4",
                        LocalDateTime.now()
                )
        );
        System.out.println("¡Guardado con éxito!");

        //Getting the data
        GetPayloadUseCase getPayloadUseCase = new GetPayloadUseCase(clipboardRepositoryPort);
        getPayloadUseCase.getPayload("andrick1");
    }
}