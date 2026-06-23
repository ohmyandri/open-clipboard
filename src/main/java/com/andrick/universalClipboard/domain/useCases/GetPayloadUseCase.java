package com.andrick.universalClipboard.domain.useCases;

import com.andrick.universalClipboard.application.ports.out.ClipboardRepositoryPort;
import com.andrick.universalClipboard.domain.models.ClipboardItem;

import javax.swing.text.html.Option;
import java.util.Optional;

public class GetPayloadUseCase {
    private final ClipboardRepositoryPort clipboardRepositoryPort;

    public GetPayloadUseCase(ClipboardRepositoryPort clipboardRepositoryPort) {
        this.clipboardRepositoryPort = clipboardRepositoryPort;
    }

    public Optional <ClipboardItem> getPayload(String userId){
        Optional <ClipboardItem> OptionalData =clipboardRepositoryPort.get(userId);
        System.out.println(OptionalData);
        return OptionalData;
    }
}