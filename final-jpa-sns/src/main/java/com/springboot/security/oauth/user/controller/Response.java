package com.springboot.security.oauth.user.controller;

import lombok.Data;
import lombok.Setter;
import lombok.Getter;

@Data
@Getter
@Setter
public class Response {

    private int status;
    private String message;
    private Object data;

    public Response() {
        this.status = 0;
        this.data =new Object();
        this.message = "";
    }
    
}