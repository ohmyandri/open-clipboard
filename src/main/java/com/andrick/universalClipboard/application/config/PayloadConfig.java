package com.andrick.universalClipboard.application.config;

import com.andrick.universalClipboard.application.use_cases.*;
import com.andrick.universalClipboard.domain.ports.out.ClipboardRepositoryPort;
import com.andrick.universalClipboard.domain.ports.out.NotificationPort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PayloadConfig {
    @Bean
    public UploadPayloadUseCase uploadPayloadUseCase(ClipboardRepositoryPort repositoryPort, NotificationPort notificationPort){
        return new UploadPayloadUseCase(repositoryPort, notificationPort);
    }

    @Bean
    public GetPayloadUseCase getPayloadUseCase(ClipboardRepositoryPort repositoryPort) {
        return new GetPayloadUseCase(repositoryPort);
    }
}
