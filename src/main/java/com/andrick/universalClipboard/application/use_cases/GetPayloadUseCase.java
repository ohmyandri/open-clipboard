package com.andrick.universalClipboard.application.use_cases;

import com.andrick.universalClipboard.domain.ports.out.ClipboardRepositoryPort;
import com.andrick.universalClipboard.domain.models.ClipboardItem;

import java.util.Optional;

public class GetPayloadUseCase {
    private final ClipboardRepositoryPort clipboardRepositoryPort;

    //Inyeccion de
    public GetPayloadUseCase(ClipboardRepositoryPort clipboardRepositoryPort) {
        this.clipboardRepositoryPort = clipboardRepositoryPort;
    }

    public Optional <ClipboardItem> getPayload(String userId){
        Optional <ClipboardItem> OptionalData =clipboardRepositoryPort.get(userId);
        System.out.println(OptionalData);
        return OptionalData;
    }
}