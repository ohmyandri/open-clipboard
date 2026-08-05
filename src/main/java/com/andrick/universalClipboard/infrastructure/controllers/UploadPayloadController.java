package com.andrick.universalClipboard.infrastructure.controllers;

import com.andrick.universalClipboard.application.use_cases.Payload.UploadPayloadUseCase;
import com.andrick.universalClipboard.application.dto.CreateClipboardItem;
import org.springframework.web.bind.annotation.*;

@RestController

@RequestMapping("/api/v1/clipboard")
@CrossOrigin(origins = "*")
public class UploadPayloadController {
    private final UploadPayloadUseCase uploadPayloadUseCase;

    public UploadPayloadController(UploadPayloadUseCase uploadPayloadUseCase) {
        this.uploadPayloadUseCase = uploadPayloadUseCase;
    }

    @PostMapping
    public void save(@RequestBody CreateClipboardItem rawData){
        uploadPayloadUseCase.uploadPayload(rawData);
        System.out.println("Payload uploaded successfully");
    }
}
