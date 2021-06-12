package com.totonero.analysisservice.config;

import com.totonero.analysisservice.integration.footballApi.client.FootballApiClient;
import com.totonero.analysisservice.integration.notification.client.NotificationClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableFeignClients(clients = {NotificationClient.class, FootballApiClient.class})
public class FeignConfig {

}