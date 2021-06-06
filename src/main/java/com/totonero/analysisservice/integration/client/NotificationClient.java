package com.totonero.analysisservice.integration.client;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

import com.totonero.analysisservice.integration.dto.MessageRequestDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "notificationClient", url = "${integration.notification-client.baseUrl}")
public interface NotificationClient {

    @PostMapping(path = "/notification/whatsapp", consumes = APPLICATION_JSON_VALUE)
    ResponseEntity sendMessage(@RequestBody final MessageRequestDTO messageRequestDTO);
}
