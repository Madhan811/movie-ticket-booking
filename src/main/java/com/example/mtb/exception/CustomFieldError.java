package com.example.mtb.exception;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class CustomFieldError {
    private String field;
    private Object rejectedValue;
    private String message;
}

