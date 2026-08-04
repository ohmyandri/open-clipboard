package com.andrick.universalClipboard.infrastructure.controllers;

import com.andrick.universalClipboard.application.use_cases.Payload.GetPayloadUseCase;
import com.andrick.universalClipboard.domain.models.clipboard.ClipboardItem;
import org.springframework.web.bind.annotation.*;

@RestController

@RequestMapping("/api/v1/clipboard")
public class GetPayloadController {
    private final GetPayloadUseCase getPayloadUseCase;

    public GetPayloadController(GetPayloadUseCase getPayloadUseCase) {
        this.getPayloadUseCase = getPayloadUseCase;
    }

    @GetMapping()
    public ClipboardItem get(
            @RequestHeader("X-User-Id") String userId
    ){
        return getPayloadUseCase.getPayload(userId);
    }
}
