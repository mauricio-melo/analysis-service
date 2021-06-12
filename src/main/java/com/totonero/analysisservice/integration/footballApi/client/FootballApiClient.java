package com.totonero.analysisservice.integration.footballApi.client;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

import java.util.Map;

import com.totonero.analysisservice.integration.footballApi.response.FixtureResponseDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "FootballApiClient", url = "${integration.footballapi-client.base-url}")
public interface FootballApiClient {

    @GetMapping(path = "/fixtures", produces = APPLICATION_JSON_VALUE)
    ResponseEntity<FixtureResponseDTO> getFixtureById(@RequestParam final Map<String, String> params);
}
