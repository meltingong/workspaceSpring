package com.itwill.ilhajob.common.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ModalController {

    @GetMapping("/login-popup")
    public ResponseEntity<String> showLoginPopup() {
    	String html = ""; // html 파일 내용을 읽어와서 변수에 저장

    	try {
    	    Resource resource = new ClassPathResource("templates/login-popup.html");
    	    InputStream inputStream = resource.getInputStream();
    	    html = new BufferedReader(new InputStreamReader(inputStream))
    	         .lines().collect(Collectors.joining("\n"));
    	} catch (IOException e) {
    	     e.printStackTrace();
    	     // 예외 처리
    	}

    	HttpHeaders headers = new HttpHeaders();
    	headers.setContentType(MediaType.TEXT_HTML);

    	return new ResponseEntity<>(html, headers, HttpStatus.OK);
    }
    
    @GetMapping("/register-popup")
    public ResponseEntity<String> showRegisterPopup() {
    	String html = "";
    	try {
    	    Resource resource = new ClassPathResource("templates/register-popup.html");
    	    InputStream inputStream = resource.getInputStream();
    	    html = new BufferedReader(new InputStreamReader(inputStream))
    	         .lines().collect(Collectors.joining("\n"));
    	} catch (IOException e) {
    	     e.printStackTrace();
    	     // 예외 처리
    	}

    	HttpHeaders headers = new HttpHeaders();
    	headers.setContentType(MediaType.TEXT_HTML);

    	return new ResponseEntity<>(html, headers, HttpStatus.OK);
    }
}
