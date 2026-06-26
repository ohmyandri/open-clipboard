package com.andrick.universalClipboard.application.use_cases;

import com.andrick.universalClipboard.domain.ports.out.ClipboardRepositoryPort;
import com.andrick.universalClipboard.domain.models.clipboard.ClipboardItem;

import java.util.Optional;

public class GetPayloadUseCase {
    private final ClipboardRepositoryPort clipboardRepositoryPort;

    //Constructor-based dependencies injection
    public GetPayloadUseCase(ClipboardRepositoryPort clipboardRepositoryPort) {
        this.clipboardRepositoryPort = clipboardRepositoryPort;
    }

    public ClipboardItem getPayload(String userId){
        Optional <ClipboardItem> optionalPayload = clipboardRepositoryPort.get(userId);
        if (optionalPayload.isEmpty()) throw new IllegalArgumentException("Payload inexistent, the user hasn't copied anything yet");
        return optionalPayload.get();
    }
}