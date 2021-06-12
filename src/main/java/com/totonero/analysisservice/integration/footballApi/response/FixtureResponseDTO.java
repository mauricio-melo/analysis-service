package com.totonero.analysisservice.integration.footballApi.response;

import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FixtureResponseDTO {

    @JsonProperty("response")
    private List<FixtureDTO> response;

    @Data
    public static class FixtureDTO {
        @JsonProperty("teams")
        private Map<String, TeamDTO> teams;

        @JsonProperty("goals")
        private Map<String, Integer> goals;
    }
}
