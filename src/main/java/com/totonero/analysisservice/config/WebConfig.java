package com.totonero.analysisservice.config;

import com.totonero.analysisservice.config.converter.StringToBetTypeConverter;
import com.totonero.analysisservice.config.converter.StringToPeriodConverter;
import com.totonero.analysisservice.config.converter.StringToRulesConverter;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addFormatters(FormatterRegistry registry) {
        registry.addConverter(new StringToRulesConverter());
        registry.addConverter(new StringToBetTypeConverter());
        registry.addConverter(new StringToPeriodConverter());
    }

}