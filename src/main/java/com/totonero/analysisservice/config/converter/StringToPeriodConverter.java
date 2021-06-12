package com.totonero.analysisservice.config.converter;

import java.text.MessageFormat;

import com.totonero.analysisservice.enums.Period;
import com.totonero.analysisservice.exceptions.ConversionFailedException;
import org.springframework.core.convert.converter.Converter;

public class StringToPeriodConverter implements Converter<String, Period> {

    @Override
    public Period convert(final String source) {
        try {
            return Period.valueOf(source.toUpperCase());
        } catch (IllegalArgumentException e) {
            throw new ConversionFailedException(MessageFormat.format("Period not found : {0}", source));
        }
    }
}