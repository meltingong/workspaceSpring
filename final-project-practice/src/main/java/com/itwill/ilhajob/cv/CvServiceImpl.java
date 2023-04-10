package com.itwill.ilhajob.cv;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CvServiceImpl implements CvService{

	@Autowired
	private CvDao cvDao;

	public CvServiceImpl(CvDao cvDao) {
		this.cvDao = cvDao;
	}

	public CvDao getCvDao() {
		return cvDao;
	}

	public void setCvDao(CvDao cvDao) {
		this.cvDao = cvDao;
	}

	@Override
	public Cv selectByCv(int cvSeq) {
		return cvDao.selectByCv(cvSeq);
	}
	
	@Override
	public List<Cv> selectAll() {
		return cvDao.selectAll();
	}

	@Override
	public List<Cv> findCvListByUserSeq(int userSeq) {
		return cvDao.findCvListByUserSeq(userSeq);
	}

	@Override
	public int createCv(Cv cv) {
		return cvDao.createCv(cv);
	}

	@Override
	public int updateCv(Cv cv) {
		return cvDao.updateCv(cv);
	}

	@Override
	public int remove(int cvSeq) {
		return cvDao.remove(cvSeq);
	}

	@Override
	public Cv detailCv(int cvSeq) {
		return cvDao.detailCv(cvSeq);
	}
	
	//한 회사가 올린 공고 하나의 이력서 목록 불러오기
//	@Override
//	public List<Cv> findCvListByCorpId(String corpId) {
//		return cvDao.findCvListByCorpId(corpId);
//	}
	
	
	
	
	

}
