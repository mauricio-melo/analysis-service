package com.totonero.analysisservice.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AlertDTO {
    private Long id;
    private RuleDTO rule;
    private Long fixtureId;
    private Long leagueId;
    private Long favoriteTeamId;
}
