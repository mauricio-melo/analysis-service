package com.totonero.analysisservice.processor.impl;

import static com.totonero.analysisservice.constant.AnalyzableRules.FAVORITE_TEAM_LOSING;

import com.totonero.analysisservice.enums.BetType;
import com.totonero.analysisservice.enums.Period;
import com.totonero.analysisservice.enums.Rules;
import com.totonero.analysisservice.processor.TypeAnalysis;
import com.totonero.analysisservice.service.AlertService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service(FAVORITE_TEAM_LOSING)
@RequiredArgsConstructor
public class FavoriteTeamLosingProcessor implements TypeAnalysis {

    private final AlertService alertService;

    @Override
    public void analysing(final Long fixtureId, final BetType betType, final Period period) {
        final boolean isLosing = true;
        if (isLosing) {
            alertService.save(Rules.FAVORITE_TEAM_LOSING, fixtureId, betType, period);
        }
    }
}
