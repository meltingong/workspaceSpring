package com.springboot.security.oauth.corp.exception;

public class PasswordMismatchException extends Exception {
	public PasswordMismatchException(String msg) {
		super(msg);
	}
}
