package com.totonero.analysisservice.config.converter;

import java.text.MessageFormat;

import com.totonero.analysisservice.enums.BetType;
import com.totonero.analysisservice.exceptions.ConversionFailedException;
import com.totonero.analysisservice.exceptions.ResourceNotFoundException;
import com.totonero.analysisservice.exceptions.TypeNotFound;
import org.springframework.core.convert.converter.Converter;

public class StringToBetTypeConverter implements Converter<String, BetType> {

    @Override
    public BetType convert(final String source) {
        try {
            return BetType.valueOf(source.toUpperCase());
        } catch (IllegalArgumentException e) {
            throw new ConversionFailedException(MessageFormat.format("BetType not found : {0}", source));
        }
    }
}