package com.totonero.analysisservice.processor.factory;

import com.totonero.analysisservice.enums.Rules;
import com.totonero.analysisservice.processor.TypeAnalysis;

public interface FactoryProcessor {
    TypeAnalysis analyseRule(final Rules rule);
}
