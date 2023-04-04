package com.itwill.ilhajob.recruit;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RecruitServiceImpl implements RecruitService {
	
	@Autowired
	private RecruitDao recruitDao; 
	
	public RecruitServiceImpl(RecruitDao recruitDao) {
		this.recruitDao = recruitDao;
	}
	
	@Override
	public int saveRecruit(Recruit recruit) throws Exception {
		return recruitDao.insertRecruit(recruit);
	}

	@Override
	public int updateRecruit(Recruit recruit) throws Exception {
		return recruitDao.updateBySeq(recruit);
	}

	@Override
	public int removeRecruit(Map<String, Object> map) throws Exception {
		return recruitDao.deleteBySeq(map);
	}

	@Override
	public List<Recruit> findRecruitListAll() throws Exception {
		return recruitDao.findAll();
	}
	
	@Override
	public List<Recruit> findRecruitListByCorpId(String corpId) throws Exception {
		return recruitDao.findByCorpId(corpId);
	}

	@Override
	public List<Recruit> findRecruitListByJob(String job) throws Exception {
		return recruitDao.findByJob(job);
	}

	@Override
	public Recruit findRecruit(int rcSeq) throws Exception {
		return recruitDao.findBySeq(rcSeq);
	}

}
