package com.totonero.analysisservice.config;

import com.totonero.analysisservice.integration.client.NotificationClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableFeignClients(clients = {NotificationClient.class})
public class FeignConfig {

}