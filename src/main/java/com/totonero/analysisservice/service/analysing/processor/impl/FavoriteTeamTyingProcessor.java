package com.totonero.analysisservice.service.analysing.processor.impl;

import static com.totonero.analysisservice.constant.AnalyzableRules.FAVORITE_TEAM_TYING;

import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

import com.totonero.analysisservice.domain.AlertDTO;
import com.totonero.analysisservice.enums.BetType;
import com.totonero.analysisservice.enums.Period;
import com.totonero.analysisservice.enums.Rules;
import com.totonero.analysisservice.integration.footballApi.response.FixtureResponseDTO;
import com.totonero.analysisservice.integration.footballApi.service.FootballApiService;
import com.totonero.analysisservice.service.AlertService;
import com.totonero.analysisservice.service.analysing.processor.TypeAnalysis;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service(FAVORITE_TEAM_TYING)
@RequiredArgsConstructor
public class FavoriteTeamTyingProcessor implements TypeAnalysis {

    private final FootballApiService footballApiService;
    private final AlertService alertService;

    @Override
    public void analysing(final AlertDTO alertDTO, final BetType betType, final Period period) {
        final FixtureResponseDTO.FixtureDTO fixture = footballApiService.getFixtureById(alertDTO.getFixtureId());
        if (isFavoriteTeamTying(alertDTO, fixture)) {
            verifyExistsAlertTeamLosing(alertDTO.getFixtureId(), betType, period);
            alertService.save(Rules.FAVORITE_TEAM_TYING, alertDTO.getFixtureId(), betType, period);
        }
    }

    private boolean isFavoriteTeamTying(final AlertDTO alertDTO, final FixtureResponseDTO.FixtureDTO fixture) {
        final String favoriteCondition = fixture.getTeams().entrySet()
                .stream()
                .filter(team -> Objects.equals(team.getValue().getId(), alertDTO.getFavoriteTeamId().toString()))
                .map(Map.Entry::getKey)
                .collect(Collectors.toList()).get(0);

        final String other = fixture.getGoals().keySet()
                .stream()
                .filter(s -> !Objects.equals(s, favoriteCondition))
                .collect(Collectors.toList()).get(0);

        return fixture.getGoals().get(favoriteCondition).equals(fixture.getGoals().get(other));
    }

    private void verifyExistsAlertTeamLosing(final Long fixtureId, final BetType betType, final Period period) {
        alertService.findByFixtureIdAndRuleNameAndBetAndPeriod(fixtureId, Rules.FAVORITE_TEAM_LOSING, betType, period)
                .ifPresent(alertDTO -> alertService.delete(alertDTO.getId()));
    }
}
