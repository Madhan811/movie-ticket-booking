package com.example.mtb.handler;

import com.example.mtb.exception.CustomFieldError;
import com.example.mtb.utility.ErrorStructure;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.ArrayList;
import java.util.List;

@ControllerAdvice
public class FieldErrorExceptionHandler extends ResponseEntityExceptionHandler {

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
        List<ObjectError> objectErrors = ex.getAllErrors();
        List<CustomFieldError> listCustomFieldErrors = new ArrayList<>();
        for (ObjectError objectError : objectErrors) {
            FieldError fieldError = (FieldError) objectError;
            CustomFieldError customFieldError = CustomFieldError.builder()
                    .field(fieldError.getField())
                    .rejectedValue(fieldError.getRejectedValue())
                    .message(fieldError.getDefaultMessage())
                    .build();
            listCustomFieldErrors.add(customFieldError);
        }
        ErrorStructure<Object> errorStructure = ErrorStructure.builder()
                .message("can not be null")
                .errorCode(HttpStatus.BAD_REQUEST.value())
                .error(listCustomFieldErrors)
                .build();
        return new ResponseEntity<>(errorStructure, HttpStatus.BAD_REQUEST);
    }
}
