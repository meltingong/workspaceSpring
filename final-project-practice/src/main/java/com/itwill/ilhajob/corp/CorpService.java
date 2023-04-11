package com.itwill.ilhajob.corp;

import java.util.List;

import com.itwill.ilhajob.user.User;

public interface CorpService {

	/*
	 * 기업가입
	 */
	// id, password, name 으로 가입
	int create(Corp corp) throws Exception;

	/*
	 * 기업로그인
	 */
	int login(String corpId,String corpPassword) throws Exception;
	/*
	 * 기업로그아웃
	 */

	/*
	 * 기업 기본정보상세보기
	 */
	Corp findCorp(String corpId) throws Exception;

	/*
	 * 기업 추가정보등록 및 수정
	 */
	int update(Corp corp) throws Exception;

	/*
	 * 기업탈퇴
	 */
	int remove(String corpId) throws Exception;

	/*
	 * 아이디중복체크
	 */
	boolean isDuplicateId(String corpId) throws Exception;
	
	//회사 이미지리스트와 매니저정보 리스트로 불러오기 (공고등록용)
	public Corp findCorpWithimagesAndManagers(String corpId) throws Exception;
	
	//회사 오더와 상품정보 가져오기
	public Corp findCorpWithOrdersWithProduct(String corpId) throws Exception;
	
	//회사 공고정보목록 가져오기
	public Corp findCorpWithRecruits(String corpId) throws Exception;
	
	//회사 리뷰 목록 가져오기
	public Corp findCorpWithReviews(String corpId) throws Exception;
	
	//회사 리스트
	public List<Corp> findCorpAll() throws Exception;
	
	//회사 검색기능
	public List<Corp> searchCorpList(String query) throws Exception;
}
