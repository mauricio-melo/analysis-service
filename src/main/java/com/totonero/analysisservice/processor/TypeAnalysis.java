package com.totonero.analysisservice.processor;

import com.totonero.analysisservice.enums.BetType;
import com.totonero.analysisservice.enums.Period;
import com.totonero.analysisservice.enums.Rules;

public interface TypeAnalysis {
    void analysing(final Long fixtureId, final BetType betType, final Period period);
}
