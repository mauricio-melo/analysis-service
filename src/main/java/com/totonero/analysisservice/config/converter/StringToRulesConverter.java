package com.totonero.analysisservice.config.converter;

import java.text.MessageFormat;

import com.totonero.analysisservice.enums.Rules;
import com.totonero.analysisservice.exceptions.ConversionFailedException;
import org.springframework.core.convert.converter.Converter;

public class StringToRulesConverter implements Converter<String, Rules> {

    @Override
    public Rules convert(final String source) {
        try {
            return Rules.valueOf(source.toUpperCase());
        } catch (IllegalArgumentException e) {
            throw new ConversionFailedException(MessageFormat.format("Rules not found : {0}", source));
        }
    }
}