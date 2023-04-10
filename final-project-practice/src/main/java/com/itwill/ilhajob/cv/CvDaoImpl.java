package com.itwill.ilhajob.cv;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.itwill.ilhajob.cv.mapper.CvMapper;

@Repository
public class CvDaoImpl implements CvDao{

	@Autowired
	private CvMapper cvMapper;

	@Override
	public Cv selectByCv(int cvSeq) {
		return cvMapper.selectByCv(cvSeq);
	}

	@Override
	public List<Cv> selectAll() {
		return cvMapper.selectAll();
	}
/*
	@Override
	public List<Cv> findCvOfUser(String userEmail) {
		return cvMapper.selectByCvOfUserEmail(userEmail);
	}
*/
	@Override
	public List<Cv> findCvListByUserSeq(int userSeq) {
		return cvMapper.selectByCvOfUserSeq(userSeq);
	}
	
	@Override
	public int createCv(Cv cv) {
		return cvMapper.insertCv(cv);
	}

	@Override
	public int updateCv(Cv cv) {
		return cvMapper.updateCv(cv);
	}

	@Override
	public int remove(int cvSeq) {
		return cvMapper.deleteCv(cvSeq);
	}

	@Override
	public Cv detailCv(int cvSeq) {
		return cvMapper.selectDetailCv(cvSeq);
	}

	//한 회사가 올린 공고 하나의 이력서 목록 불러오기
//	@Override
//	public List<Cv> findCvListByCorpId(String corpId) {
//		return cvMapper.findCvListByCorpId(corpId);
//	}
	
	
	
	
}
