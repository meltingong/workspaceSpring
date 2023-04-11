package com.itwill.ilhajob.recruit;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.itwill.ilhajob.corp.Corp;
import com.itwill.ilhajob.recruit.mapper.RecruitMapper;

@Repository
public class RecruitDaoImpl implements RecruitDao {

    @Autowired
    private RecruitMapper recruitMapper;

    public RecruitDaoImpl(RecruitMapper recruitMapper) {
        this.recruitMapper = recruitMapper;
    }

    @Override
    public int insertRecruit(Recruit recruit) throws Exception {
        return recruitMapper.insertRecruit(recruit);
    }

    @Override
    public List<Recruit> findAllWithCorp() throws Exception {
    	return recruitMapper.findAllWithCorp();
    }
    
    @Override
    public List<Recruit> findByCorpId(Corp corp) throws Exception {
        return recruitMapper.findByCorpId(corp);
    }

    @Override
    public List<Recruit> findByJob(String job) throws Exception {
        return recruitMapper.findByJob(job);
    }

    @Override
    public Recruit findBySeq(int rcSeq) throws Exception {
        return recruitMapper.findBySeq(rcSeq);
    }

    @Override
    public int updateBySeq(Recruit recruit) throws Exception {
        return recruitMapper.updateBySeq(recruit);
    }

    @Override
    public int deleteBySeq(Map<String, Object> map) throws Exception {
    	return recruitMapper.deleteBySeq(map);
    }
	
	
}
