package com.itwill.ilhajob.recruit;

import java.util.List;
import java.util.Map;

public interface RecruitDao {
	
	public int insertRecruit(Recruit recruit) throws Exception;
	
	public List<Recruit> findAll() throws Exception;
	
	public List<Recruit> findByCorpId(String corpId) throws Exception;
	
	public List<Recruit> findByJob(String job) throws Exception;
	
	public Recruit findBySeq(int rcSeq) throws Exception;
	
	public int updateBySeq(Recruit recruit) throws Exception;
	
	public int deleteBySeq(Map<String, Object> map) throws Exception;
}