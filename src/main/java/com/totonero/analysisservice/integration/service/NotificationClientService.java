package com.totonero.analysisservice.integration.service;

import com.totonero.analysisservice.integration.client.NotificationClient;
import com.totonero.analysisservice.integration.dto.MessageRequestDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class NotificationClientService {

    private final NotificationClient client;

    public void sendMessage(final String message) {
        final MessageRequestDTO requestDTO = MessageRequestDTO.builder()
                .message(message)
                .build();
        final ResponseEntity responseEntity = client.sendMessage(requestDTO);
        validateResponse(responseEntity);
    }

    private void validateResponse(final ResponseEntity responseEntity) {
        if (!responseEntity.getStatusCode().is2xxSuccessful()) {
            //LANCAR EXCEPTION
        }
    }
}
