package com.itwill.ilhajob.recruit;

import java.util.List;
import java.util.Map;

import com.itwill.ilhajob.corp.Corp;

public interface RecruitDao {
	
	public int insertRecruit(Recruit recruit) throws Exception;
	
	public List<Recruit> findAllWithCorp() throws Exception;
	
	public List<Recruit> findByCorpId(Corp corp) throws Exception;
	
	public List<Recruit> findByJob(String job) throws Exception;
	
	public Recruit findBySeq(int rcSeq) throws Exception;
	
	public int updateBySeq(Recruit recruit) throws Exception;
	
	public int deleteBySeq(Map<String, Object> map) throws Exception;
}