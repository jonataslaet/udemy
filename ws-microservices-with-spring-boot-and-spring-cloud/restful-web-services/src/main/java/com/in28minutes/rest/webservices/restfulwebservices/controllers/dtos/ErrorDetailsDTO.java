package com.in28minutes.rest.webservices.restfulwebservices.controllers.dtos;

import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ErrorDetailsDTO {

    private LocalDateTime timestamp;
    private String message;
    private String debugMessage;
    private String requestMessage;
    private Integer httpStatusCode;
    private List<CustomizedFieldError> fieldErrors;

    public ErrorDetailsDTO(LocalDateTime timestamp, String message, String debugMessage, String requestMessage, Integer httpStatusCode) {
        this.timestamp = timestamp;
        this.message = message;
        this.debugMessage = debugMessage;
        this.requestMessage = requestMessage;
        this.httpStatusCode = httpStatusCode;
        this.fieldErrors = new ArrayList<>();
    }

    public ErrorDetailsDTO(LocalDateTime timestamp, String message, String debugMessage, String requestMessage, Integer httpStatusCode, List<CustomizedFieldError> fieldErrors) {
        this.timestamp = timestamp;
        this.message = message;
        this.debugMessage = debugMessage;
        this.requestMessage = requestMessage;
        this.httpStatusCode = httpStatusCode;
        this.fieldErrors = Objects.nonNull(fieldErrors) ? fieldErrors : new ArrayList<>();
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public String getMessage() {
        return message;
    }

    public String getDebugMessage() {
        return debugMessage;
    }

    public String getRequestMessage() {
        return requestMessage;
    }

    public Integer getHttpStatusCode() {
        return httpStatusCode;
    }

    public List<CustomizedFieldError> getFieldErrors() {
        return fieldErrors;
    }
}
