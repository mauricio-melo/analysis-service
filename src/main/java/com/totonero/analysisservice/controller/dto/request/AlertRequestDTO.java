package com.totonero.analysisservice.controller.dto.request;

import com.totonero.analysisservice.enums.BetType;
import com.totonero.analysisservice.enums.Period;
import com.totonero.analysisservice.enums.Rules;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AlertRequestDTO {
    private Rules rule;
    private Long fixtureId;
    private BetType betType;
    private Period period;
    private Long leagueId;
    private Long favoriteTeamId;
}
