package com.itwill.ilhajob.cv;

import java.util.List;

public interface CvService {
	/*
	 * cv seq로 이력서 찾기
	 */
	
	Cv selectByCv(int cvSeq);
	
	/*
	 * cv 전체 리스트
	 */
	List<Cv> selectAll();
	
	/*
	 * userSeq로 해당 회원의 cv 전체 리스트 찾기
	 */
	List<Cv> findCvListByUserSeq(int userSeq);
	
	//List<Cv> findCvOfUser(String userEmail);
	
	/*
	 * 회원의 각 이력서 상세보기
	 */
	Cv detailCv(int cvSeq);
	/*
	 * 이력서 추가
	 */
	int createCv(Cv cv);
	
	/*
	 * 이력서 업데이트
	 */
	int updateCv(Cv cv);
	
	/*
	 *이력서 삭제 
	 */
	int remove(int cvSeq);
	
	//한 회사가 올린 공고 하나의 이력서 목록 불러오기
	//List<Cv> findCvListByCorpId(String corpId);
}
