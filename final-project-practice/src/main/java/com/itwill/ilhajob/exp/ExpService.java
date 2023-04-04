package com.itwill.ilhajob.exp;

import java.util.List;

public interface ExpService {
	
	/*
	 * 유저seq로 경력사항 찾기
	 */
	
	List<Exp> selectByUserSeq(int userSeq);
	
	/*
	 * 유저 email 로 경력사항 찾기
	 */
	
	//List<Exp> selectByUserEmail(String userEmail);
	
	/*
	 * 경력사항 추가
	 */
	int insertExp(Exp exp);
	
	/*
	 * 경력 수정
	 */
	int updateExp(Exp exp);
	
	/*
	 * 경력 삭제
	 */
	int deleteExp(int expSeq);
	
	
}
