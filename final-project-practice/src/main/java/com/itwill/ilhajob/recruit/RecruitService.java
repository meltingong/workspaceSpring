package com.itwill.ilhajob.recruit;

import java.util.List;
import java.util.Map;

public interface RecruitService {
	
	//공고등록
	int saveRecruit(Recruit recruit) throws Exception;
	//공고수정
	int updateRecruit(Recruit recruit) throws Exception;
	//공고삭제
	int removeRecruit(Map<String, Object> map) throws Exception;
	
	List<Recruit> findRecruitListAll() throws Exception;
	
	//corp회원이 등록한 공고리스트
	List<Recruit> findRecruitListByCorpId(String corpId) throws Exception;
	//직무별 공고리스트
	List<Recruit> findRecruitListByJob(String job) throws Exception;
	//공고 상세
	Recruit findRecruit(int rcSeq) throws Exception;
}