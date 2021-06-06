package com.totonero.analysisservice.processor.impl;

import static com.totonero.analysisservice.constant.AnalyzableRules.FAVORITE_TEAM_TYING;

import com.totonero.analysisservice.enums.BetType;
import com.totonero.analysisservice.enums.Period;
import com.totonero.analysisservice.enums.Rules;
import com.totonero.analysisservice.processor.TypeAnalysis;
import com.totonero.analysisservice.service.AlertService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service(FAVORITE_TEAM_TYING)
@RequiredArgsConstructor
public class FavoriteTeamTyingProcessor implements TypeAnalysis {

    private final AlertService alertService;

    @Override
    public void analysing(final Long fixtureId, final BetType betType, final Period period) {
        final boolean isTying = false;
        if (isTying) {
            alertService.save(Rules.FAVORITE_TEAM_TYING, fixtureId, betType, period);
        }
    }
}
