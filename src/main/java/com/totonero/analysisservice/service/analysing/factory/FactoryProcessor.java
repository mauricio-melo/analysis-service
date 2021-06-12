package com.totonero.analysisservice.service.analysing.factory;

import com.totonero.analysisservice.enums.Rules;
import com.totonero.analysisservice.service.analysing.processor.TypeAnalysis;

public interface FactoryProcessor {
    TypeAnalysis analyseRule(final Rules rule);
}
