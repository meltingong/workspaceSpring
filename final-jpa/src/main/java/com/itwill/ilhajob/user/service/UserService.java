package com.itwill.ilhajob.user.service;

import java.util.ArrayList;
import java.util.List;

import com.itwill.ilhajob.user.dto.UserDto;

public interface UserService {

	/*
	 * 회원가입
	 */
	/**************1.반환값사용***********************/
	UserDto create(UserDto userDto) throws Exception;
	/*********************************************/

	/*
	 * 회원로그인
	 * 
	 * 0:아이디존재안함
	 * 1:패쓰워드 불일치
	 * 2:로그인성공
	 */
	UserDto login(String userEmail, String userPassword) throws Exception;
	/*
	 * 회원로그아웃
	 */

	/*
	 * 회원상세보기
	 */
	UserDto findUser(String userEmail) throws Exception;

	/*
	 * 회원수정
	 */
	UserDto update(Long id, UserDto userDto) throws Exception;

	/*
	 * 회원탈퇴
	 */
	void remove(Long id) throws Exception;

	/*
	 * 아이디중복체크
	 */
	boolean isDuplicateEmail(String userEmail) throws Exception;

}