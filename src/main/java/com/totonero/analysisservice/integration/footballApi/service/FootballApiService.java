package com.totonero.analysisservice.integration.footballApi.service;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import com.totonero.analysisservice.integration.footballApi.client.FootballApiClient;
import com.totonero.analysisservice.integration.footballApi.response.FixtureResponseDTO;
import com.totonero.analysisservice.integration.footballApi.response.FixtureResponseDTO.FixtureDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FootballApiService {

    private final FootballApiClient client;
    private final static String DRAW = "Draw";

    public FixtureDTO getFixtureById(final Long fixture) {
        final Map<String, String> params = new HashMap<>();
        params.put("id", fixture.toString());
        final ResponseEntity<FixtureResponseDTO> response = client.getFixtureById(params);
        if (response.getStatusCode().is2xxSuccessful()) {
            return response.getBody().getResponse().get(0);
        }
        return null;
    }

    public String getNameTeam(final String value, final FixtureDTO fixture) {
        if (value.equals(DRAW)) {
            return value;
        } else {
            return fixture.getTeams().get(value.toLowerCase(Locale.ROOT)).getName();
        }
    }

}
