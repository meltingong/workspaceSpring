package com.itwill.user.controller;


public class ResponseMessage {
    public static final String LOGIN_SUCCESS = "회원 로그인 성공";
    public static final String READ_USER = "회원 정보 조회 성공";
    public static final String CREATED_USER = "회원 가입 성공";
    public static final String UPDATE_USER = "회원 정보 수정 성공";
    public static final String DELETE_USER = "회원 탈퇴 성공";
    public static final String LOGOUT_USER = "회원 로그 아웃";

    public static final String NOT_FOUND_USER = "회원을 찾을 수 없습니다.";
    public static final String LOGIN_FAIL = "회원 로그인 실패";
    public static final String ERROR_USER = "회원아이디중복,패쓰워드불일치";
    public static final String EXISTED_USER = "회원아이디중복";
    public static final String PASSWORD_MISMATCH_USER = "회원패쓰워드불일치";
    public static final String UNAUTHORIZED_USER = "인증받지않은요청입니다.";
    
}