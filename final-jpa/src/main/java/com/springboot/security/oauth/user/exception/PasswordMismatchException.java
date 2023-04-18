package com.springboot.security.oauth.user.exception;

public class PasswordMismatchException extends Exception {
	public PasswordMismatchException(String msg) {
		super(msg);
	}
}
