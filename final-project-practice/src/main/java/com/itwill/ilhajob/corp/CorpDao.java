package com.itwill.ilhajob.corp;

import java.util.List;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Repository;

public interface CorpDao {
	
	// 회사계정 회원가입(아이디,비밀번호,회사명만 입력)
	int insertCorp(Corp corp) throws Exception;
	
	// 회사계정 아이디로 회사정보 가져오기
	Corp selectById(String corpId) throws Exception;
	
	// 모든 회사정보 가져오기
	List<Corp> selectAll() throws Exception;
	
	//회사 이미지리스트와 매니저정보 리스트로 불러오기
	Corp findCorpByIdWithAll(String corpId) throws Exception;
	
	//회사 오더와 상품정보 가져오기
	Corp findCorpByIdWithOrders(String corpId) throws Exception;
	
	//회사 공고정보목록 가져오기
	Corp findCorpByIdWithRecruit(String corpId) throws Exception;
	
	//회사 리뷰 목록 가져오기
	Corp findCorpByIdWithReview(String corpId) throws Exception;
	
	// 회사 추가정보 입력하기(id로 식별)
	int updateCorp(Corp corp) throws Exception;
	
	// 회사 삭제하기(id로 식별)
	int deleteCorp(String corpId) throws Exception;
	
	boolean existedCorp(String corpId) throws Exception;
}
