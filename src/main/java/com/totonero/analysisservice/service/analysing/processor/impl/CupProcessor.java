package com.totonero.analysisservice.service.analysing.processor.impl;

import static com.totonero.analysisservice.constant.AnalyzableRules.CUP;

import com.totonero.analysisservice.domain.AlertDTO;
import com.totonero.analysisservice.enums.BetType;
import com.totonero.analysisservice.enums.Period;
import com.totonero.analysisservice.enums.Rules;
import com.totonero.analysisservice.service.AlertService;
import com.totonero.analysisservice.service.analysing.processor.TypeAnalysis;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service(CUP)
@RequiredArgsConstructor
public class CupProcessor implements TypeAnalysis {

    private final AlertService alertService;

    @Override
    public void analysing(final AlertDTO alertDTO, final BetType betType, final Period period) {
        final boolean isCup = true;
        if (isCup) {
            alertService.save(Rules.CUP, alertDTO.getFixtureId(), betType, period);
        }
    }
}
