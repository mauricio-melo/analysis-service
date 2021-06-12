package com.totonero.analysisservice.controller.advice;

import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;
import static org.springframework.http.HttpStatus.NOT_FOUND;
import static org.springframework.http.ResponseEntity.status;

import java.time.Instant;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.totonero.analysisservice.exceptions.ConversionFailedException;
import com.totonero.analysisservice.exceptions.ResourceNotFoundException;
import com.totonero.analysisservice.exceptions.TypeNotFound;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.servlet.mvc.method.annotation.ExceptionHandlerExceptionResolver;

@RestControllerAdvice
public class AnalysisExceptionHandler {

    @ExceptionHandler({ResourceNotFoundException.class})
    public ResponseEntity<ErrorResponse> handleException(final ResourceNotFoundException e) {
        return status(NOT_FOUND)
                .body(this.constructErrorResponse(NOT_FOUND, AnalysisMessage.NOT_FOUND.getMessage()));
    }

    @ExceptionHandler({Exception.class, TypeNotFound.class})
    public ResponseEntity<ErrorResponse> handleException(final Exception e) {
        return status(INTERNAL_SERVER_ERROR)
                .body(this.constructErrorResponse(INTERNAL_SERVER_ERROR, AnalysisMessage.SERVER_ERROR.getMessage()));
    }

    @ExceptionHandler({ConversionFailedException.class, MethodArgumentTypeMismatchException.class})
    public ResponseEntity<ErrorResponse> handleException(final ConversionFailedException e) {
        return status(BAD_REQUEST)
                .body(this.constructErrorResponse(BAD_REQUEST, e.getMessage()));
    }

    private ErrorResponse constructErrorResponse(final HttpStatus httpStatus, final String messages) {
        return ErrorResponse.builder()
                .timestamp(Instant.now())
                .status(httpStatus.value())
                .error(httpStatus.getReasonPhrase())
                .message(messages)
                .build();
    }

    @Setter
    @Getter
    @Builder
    private static class ErrorResponse {
        private Instant timestamp;

        private int status;

        private String error;

        @JsonProperty("error_description")
        private String message;
    }
}
