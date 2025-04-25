package com.example.mtb.utility;

import jakarta.validation.constraints.AssertFalse;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Setter
@Getter
public class ErrorStructure <T>{
    private int errorCode;
    private String message;
    private T error;

}
