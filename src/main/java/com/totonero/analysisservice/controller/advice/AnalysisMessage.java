package com.totonero.analysisservice.controller.advice;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum AnalysisMessage {

    SERVER_ERROR("An unexpected error has occurred. Please try again"),
    NOT_FOUND("Requested resource could not be found");

    private final String message;
}
