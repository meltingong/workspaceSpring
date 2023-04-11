package com.itwill.ilhajob.recruit;

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.itwill.ilhajob.corp.Corp;

public interface RecruitService {
	
	//공고등록
	int saveRecruit(Recruit recruit) throws Exception;
	//공고수정
	int updateRecruit(Recruit recruit) throws Exception;
	//공고삭제
	int removeRecruit(Map<String, Object> map) throws Exception;
	
	List<Recruit> findRecruitListAllWithCorp() throws Exception;
	
	//corp회원이 등록한 공고리스트
	List<Recruit> findRecruitListByCorpId(Corp corp) throws Exception;
	//직무별 공고리스트
	List<Recruit> findRecruitListByJob(String job) throws Exception;
	//공고 상세
	Recruit findRecruit(int rcSeq) throws Exception;
	
	//마감 지났는지 여부 확인
	//boolean isDeadLine(Date rcDeadline) throws Exception;
	
	//마감일 설정
	//Date addDay(Date date,int day) throws Exception;
	
	//마감일 상태변화
	String getStatus(Date rcDeadLine)throws Exception;
}