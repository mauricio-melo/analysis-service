package com.totonero.analysisservice.service.analysing.processor;

import com.totonero.analysisservice.domain.AlertDTO;
import com.totonero.analysisservice.enums.BetType;
import com.totonero.analysisservice.enums.Period;

public interface TypeAnalysis {
    void analysing(final AlertDTO alertDTO, final BetType betType, final Period period);
}
