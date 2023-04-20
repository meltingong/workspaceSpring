package com.itwill.ilhajob.common.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class LoginRequestDto {
	
	private String separate; // 개인회원인지 기업회원인지 구분하기 위한 값
	private String email; // user 로그인 아이디
	private String id;// corp 로그인 아이디
	private String password; // 로그인 비밀번호
}
