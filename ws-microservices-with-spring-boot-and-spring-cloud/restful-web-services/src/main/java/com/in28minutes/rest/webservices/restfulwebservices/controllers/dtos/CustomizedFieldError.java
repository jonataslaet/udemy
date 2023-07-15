package com.in28minutes.rest.webservices.restfulwebservices.controllers.dtos;

public class CustomizedFieldError {
    private String objectName;
    private String fieldName;
    private String errorMessage;
    private String rejectedValue;

    public CustomizedFieldError(String objectName, String fieldName, String errorMessage, String rejectedValue) {
        this.objectName = objectName;
        this.fieldName = fieldName;
        this.errorMessage = errorMessage;
        this.rejectedValue = rejectedValue;
    }

    public String getObjectName() {
        return objectName;
    }

    public String getFieldName() {
        return fieldName;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public String getRejectedValue() {
        return rejectedValue;
    }
}
