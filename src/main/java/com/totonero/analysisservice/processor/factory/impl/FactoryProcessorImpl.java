package com.totonero.analysisservice.processor.factory.impl;

import java.text.MessageFormat;

import com.totonero.analysisservice.enums.Rules;
import com.totonero.analysisservice.exceptions.TypeNotFound;
import com.totonero.analysisservice.processor.TypeAnalysis;
import com.totonero.analysisservice.processor.factory.FactoryProcessor;
import lombok.AllArgsConstructor;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;


@Component
@AllArgsConstructor
public class FactoryProcessorImpl implements FactoryProcessor {

    private final ApplicationContext context;

    @Override
    public TypeAnalysis analyseRule(final Rules rule) {
        final String bean = rule.name();
        if(context.containsBean(bean) && context.isTypeMatch(bean, TypeAnalysis.class)) {
            return context.getBean(bean, TypeAnalysis.class);
        }
        throw new TypeNotFound(MessageFormat.format("Type not found : {0}", rule));
    }
}
