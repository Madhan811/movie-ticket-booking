package com.example.mtb.utility;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.net.http.HttpResponse;
@Setter
@Getter
@Builder
public class ResponseStructure <T>{
    private int StatusCode;
    private String Message;
    private T data;

}
