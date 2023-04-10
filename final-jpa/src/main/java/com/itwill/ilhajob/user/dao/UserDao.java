package com.itwill.ilhajob.user.dao;

import java.util.ArrayList;
import java.util.List;

import com.itwill.ilhajob.user.dto.UserDto;

public interface UserDao {

	/*
	 * 사용자관리테이블에 새로운사용자생성
	 */
	int create(UserDto user) throws Exception;

	/*
	 * 기존의 사용자정보를 수정
	 */
	int update(UserDto user) throws Exception;

	/*
	 * 사용자아이디에해당하는 사용자를 삭제
	 */
	int remove(String userEmail) throws Exception;

	/*
	 * 사용자아이디에해당하는 정보를 데이타베이스에서 찾아서 User 도메인클래스에 저장하여 반환
	 */
	UserDto findUser(String userEmail) throws Exception;
	
	UserDto findExpAwardsEduList(int userSeq) throws Exception;
	
	UserDto findAppList(int userSeq) throws Exception;
	
	UserDto findUserByIdWithReview(int userSeq) throws Exception;
	
	/*
	 * 인자로 전달되는 아이디를 가지는 사용자가 존재하는지의 여부를판별
	 */
	boolean existedUser(String userId) throws Exception;
	
	//sns로그인 가입 판별
	boolean findBySnsId(UserDto user) throws Exception;

}