package com.in28minutes.rest.webservices.restfulwebservices.services.exceptions;

import com.in28minutes.rest.webservices.restfulwebservices.controllers.dtos.CustomizedFieldError;
import com.in28minutes.rest.webservices.restfulwebservices.controllers.dtos.ErrorDetailsDTO;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@ControllerAdvice
public class CustomizedResponseExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorDetailsDTO> handleAllErrors(Exception ex, WebRequest request) {
        final ServletWebRequest servletWebRequest = (ServletWebRequest) request;
        String requestMessage = servletWebRequest.getRequest().getRequestURI() + " " + servletWebRequest.getRequest().getRequestURI();
        ErrorDetailsDTO errorDetailsDTO = new ErrorDetailsDTO(LocalDateTime.now(), ex.getMessage(), ex.getLocalizedMessage(), requestMessage, HttpStatus.INTERNAL_SERVER_ERROR.value());
        return new ResponseEntity<>(errorDetailsDTO, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ErrorDetailsDTO> handleUserNotFoundException(Exception ex, WebRequest request) {
        final ServletWebRequest servletWebRequest = (ServletWebRequest) request;
        String requestMessage = servletWebRequest.getHttpMethod().name() + " " + servletWebRequest.getRequest().getRequestURI();
        ErrorDetailsDTO errorDetailsDTO = new ErrorDetailsDTO(LocalDateTime.now(), HttpStatus.NOT_FOUND.getReasonPhrase(), ex.getLocalizedMessage(), requestMessage, HttpStatus.NOT_FOUND.value());
        return new ResponseEntity<>(errorDetailsDTO, HttpStatus.NOT_FOUND);
    }

//    @ExceptionHandler(MethodArgumentNotValidException.class)
    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
        final ServletWebRequest servletWebRequest = (ServletWebRequest) request;
        String requestMessage = servletWebRequest.getHttpMethod().name() + " " + servletWebRequest.getRequest().getRequestURI();
        List<CustomizedFieldError> fieldErrors = ex.getFieldErrors().stream().map(fieldError ->
                        new CustomizedFieldError(fieldError.getObjectName(), fieldError.getField(), fieldError.getDefaultMessage(), fieldError.getRejectedValue().toString())).toList();
        ErrorDetailsDTO errorDetailsDTO = new ErrorDetailsDTO(LocalDateTime.now(), HttpStatus.BAD_REQUEST.getReasonPhrase(), ex.getMessage(), requestMessage, HttpStatus.BAD_REQUEST.value(), fieldErrors);
        return new ResponseEntity<>(errorDetailsDTO, HttpStatus.BAD_REQUEST);
    }
}
