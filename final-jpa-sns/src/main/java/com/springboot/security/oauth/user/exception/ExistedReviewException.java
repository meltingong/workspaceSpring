package com.springboot.security.oauth.user.exception;

public class ExistedReviewException extends Exception{
	
	private Object data;
	public ExistedReviewException(String msg) {
		super(msg);
	}
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}

}
