package com.example.vendasproducer.controller.dto;

public class ApiResult {

    private long status;
    private String message;

    public ApiResult(long status,String message) {
        this.status = status;
        this.message = message;
    }
}
