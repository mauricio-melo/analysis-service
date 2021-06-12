package com.totonero.analysisservice.integration.footballApi.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TeamDTO {

    @JsonProperty("id")
    private String id;

    @JsonProperty("name")
    private String name;
}
