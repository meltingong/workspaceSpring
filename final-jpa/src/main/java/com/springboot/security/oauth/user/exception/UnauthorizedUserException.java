package com.springboot.security.oauth.user.exception;

public class UnauthorizedUserException extends Exception{
	public UnauthorizedUserException(String msg) {
		super(msg);
	}
}
